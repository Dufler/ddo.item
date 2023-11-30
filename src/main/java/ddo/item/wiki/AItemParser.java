package ddo.item.wiki;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ddo.item.entity.EAugmentTypeAlias;
import ddo.item.entity.EEffect;
import ddo.item.entity.EEffectAliasList;
import ddo.item.entity.EItem;
import ddo.item.entity.ESet;
import ddo.item.entity.ESkippableItem;
import ddo.item.model.AugmentSlot;
import ddo.item.model.Effect;
import ddo.item.model.EffectType;
import ddo.item.model.Item;
import ddo.item.model.ItemType;
import ddo.item.model.NamedSet;
import ddo.item.repository.EAugmentTypeAliasRepository;
import ddo.item.repository.EEffectAliasListRepository;
import ddo.item.repository.EEffectRepository;
import ddo.item.repository.EItemRepository;
import ddo.item.repository.ESetRepository;
import ddo.item.repository.ESkippableItemRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AItemParser {
	
	@Value(value = "${set.misplaced}")
	protected Set<String> misplacedSet;
	
	protected final Set<String> clickies;
	
	@Autowired protected EEffectRepository effectRepository;
	@Autowired protected ESkippableItemRepository skippableItemRepository;
	@Autowired protected ESetRepository setRepository;
	@Autowired protected EEffectAliasListRepository aliasRepository;
	@Autowired protected EAugmentTypeAliasRepository augmentAliasRepository;
	@Autowired protected EItemRepository itemRepository;
	
	protected Item currentItem;
	protected Optional<EAugmentTypeAlias> currentAugmentAlias;
	
	protected AItemParser() {
		clickies = new HashSet<>();
		
	}
	
	@PostConstruct
	private void setUp() {
		List<EEffect> list = effectRepository.findByType(EffectType.clickie);
		for (EEffect e : list) {
			clickies.add(e.getEffect());
		}
	}
 
	public List<Item> parseRows(List<Element> rows, ItemType type) {
		ArrayList<Item> itemList = new ArrayList<>();
		for (Element row : rows) {
			try {
				Item item = parseItem(row, type);
				// Verifico se è già presente
				Optional<EItem> match = itemRepository.findById(item.getName());
				if (match.isEmpty()) {
					itemList.add(item);
				}
			} catch(InvalidRowException e) {
				log.error(e.getMessage());
			} catch(SkipItemException e) {
				log.error(String.format("Skipped: %s", e.getMessage()));
			}
		}
		return itemList;
	}
	
	protected abstract Item parseItem(Element row, ItemType type);
	
	protected void parseEffects(Element e, ItemType type) {
		Elements effectsList = e.children().select("> li");
		ListIterator<Element> iterator = effectsList.listIterator();
		while (iterator.hasNext()) {
			Element li = iterator.next();
			String effect;
			try {
				// controllo che ci sia uno span e un anchor
				Element span = li.child(0);
				Element anchor = span.child(0);
				effect = anchor.text();
			} catch(Exception exception) {
				log.error(exception.getMessage(), exception);
				effect = String.format("%s", li.text());
			}
			// Verifico se è un set o un augment
			if (isSet(effect)) {
				saveSetItem(effect);
			} else if (isAugument(effect)) {
				addAugment(effect);
			} else {
				parseEffect(effect);
			}
		}
	}
	
	protected void parseEffect(String effectDescription) {
		String bonusType;
		// Controllo se è un clickie
		if (clickies.contains(effectDescription)) {
			bonusType = "Clickie";
		} else if (effectDescription.matches("Sacred \\+\\d{1,2}")) {
			// E' proprio l'effetto sacred, non il tipo di bonus
			bonusType = "Enhancement";
		} else {
			// Parso il tipo di bonus, se presente
			bonusType = parseBonusType(effectDescription);
			if (bonusType != null) {
				effectDescription = effectDescription.replace(bonusType + " ", "");
			}
		}		
		// Parso il valore del bonus, se presente
		Integer bonusValue = null;
		// Elimino eventuali simboli percentuali che non servono
		effectDescription = effectDescription.replace("%", "");
		// Comincio con gli if "brutti"
		if (effectDescription.contains("Armor-Piercing")) {
			effectDescription = effectDescription.replace("-", " ");
		}
		// Provo con il più
		Pattern p = Pattern.compile("\\+\\d{1,4}");  // insert your pattern here
		Matcher m = p.matcher(effectDescription);
		if (m.find()) {
		   String value = effectDescription.substring(m.start() + 1, m.end());
			try { 
				bonusValue = Integer.parseInt(value.trim());
				effectDescription = effectDescription.replace("+" + value, "");
			} catch(Exception e) { 
				log.error(e.getMessage()); 
			}
		} else {
			p = Pattern.compile("\\-\\d{1,4}");
			m = p.matcher(effectDescription);
			if (m.find()) {
				String value = effectDescription.substring(m.start(), m.end());
				try { 
					bonusValue = Integer.parseInt(value.trim());
					bonusType = "Penality";
					effectDescription = effectDescription.replace(value, "");
				} catch(Exception e) { 
					log.error(e.getMessage());
				}
			} else {
				p = Pattern.compile("\\d{1,4}");
				m = p.matcher(effectDescription);
				if (m.find()) {
					String value = effectDescription.substring(m.start(), m.end());
					try { 
						bonusValue = Integer.parseInt(value.trim());
						effectDescription = effectDescription.replace(value, "");
					} catch(Exception e) { 
						log.error(e.getMessage()); 
					}
				}
			}
			
		}
		// Se ho un valore ma non un tipo allora imposto il default
		if (bonusType == null && bonusValue != null) {
			bonusType = "Enhancement";
		}		
	
		effectDescription = effectDescription.trim();
		if (effectDescription.endsWith(":")) {
			effectDescription = effectDescription.substring(0, effectDescription.length() - 1);
		}
		if (effectDescription.endsWith(" -")) {
			effectDescription = effectDescription.substring(0, effectDescription.length() - 2);
		}
		if (effectDescription.endsWith(" ()")) {
			effectDescription = effectDescription.substring(0, effectDescription.length() - 3);
		}
		
		if (effectDescription.length() > 100) {
			effectDescription = effectDescription.substring(0, 100);
		}
		
		// Controllo se ho un alias per questo effetto
		List<EEffectAliasList> list = aliasRepository.findByAlias(effectDescription);
		if (list.isEmpty()) {
			// Controllo se l'effetto già esiste altrimenti lo aggiungo specificando che va categorizzato
			Optional<EEffect> opt = effectRepository.findById(effectDescription);
			if (opt.isEmpty()) {
				EEffect entity = new EEffect();
				entity.setEffect(effectDescription);
				entity.setType(EffectType.uncategorized);
				effectRepository.save(entity);
			}
			// Inserisco l'effetto nell'oggetto
			Effect effect = new Effect();
			effect.setName(effectDescription);
			effect.setType(bonusType);
			effect.setValue(bonusValue);
			currentItem.addEffect(effect);
		} else for (EEffectAliasList alias : list) {
			Effect effect = new Effect();
			effect.setName(alias.getEffect());
			effect.setType(alias.getType() != null ? alias.getType() : bonusType);
			effect.setValue(alias.getValue() != null ? alias.getValue() : bonusValue);
			currentItem.addEffect(effect);
		}
	}
	
	protected void parseName(Element e, ItemType slot) {
		// Parso il titolo
		String titolo = e.text();
		Optional<ESkippableItem> skip = skippableItemRepository.findById(titolo);
		if (skip.isPresent()) {
			throw new SkipItemException(titolo);
		}
		// Creo il nuovo oggetto sul current e lo aggiungo alla lista
		currentItem = new Item(slot, titolo);		
	}
	
	protected boolean isSet(String effect) {
		for (String set : misplacedSet) {
			if (effect.contains(set)) {
				effect = set;
				break;
			}
		}
		Optional<ESet> oset = setRepository.findById(effect);
		return oset.isPresent();
	}
	
	protected void saveSetItem(String setName) {
		for (String set : misplacedSet) {
			if (setName.contains(set)) {
				setName = set;
				break;
			}
		}
		NamedSet ns = new NamedSet();
		ns.setName(setName);
		currentItem.addSet(ns);
	}
	
	protected boolean isAugument(String effect) {
		currentAugmentAlias = augmentAliasRepository.findById(effect);
		return currentAugmentAlias.isPresent();
	}
	
	protected void addAugment(String augment) {
		EAugmentTypeAlias alias = currentAugmentAlias.get();
		AugmentSlot as = new AugmentSlot(currentItem.getName(), alias.getType());
		currentItem.addAugment(as);
	}
	
	protected void parseMinimumLevel(Element e) {
		int ml;
		String text = e.text();
		try {
			if (text.equalsIgnoreCase("none")) {
				ml = 1;
			} else {
				ml = Integer.parseInt(text);
			}
			currentItem.setMinimumLevel(ml);
		} catch(Exception exception) {
			log.error(exception.getMessage());
		}
	}
	
	protected String parseBonusType(String effectDescription) {
		String type = null;
		if (effectDescription.contains("Insightful")) {
			type = "Insightful";
		}
		if (effectDescription.contains("Insight")) {
			type = "Insightful";
		}
		if (effectDescription.contains("Quality")) {
			type = "Quality";
		}
		if (effectDescription.contains("Profane")) {
			type = "Profane";
		}
		if (effectDescription.contains("Sacred")) {
			type = "Sacred";
		}
		return type;
	}
	
	protected void parseBinding(Element e) {
		// DO NOTHING
	}
	
	protected void parseQuest(Element e) {
		// DO NOTHING
	}
	
	protected void parseChest(Element e) {
		// DO NOTHING
	}
	
}

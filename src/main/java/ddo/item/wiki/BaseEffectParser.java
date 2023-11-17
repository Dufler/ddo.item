package ddo.item.wiki;

import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import ddo.item.entity.EEffectAliasList;
import ddo.item.entity.ESet;
import ddo.item.model.Effect;
import ddo.item.model.Item;
import ddo.item.model.ItemType;
import ddo.item.model.NamedSet;
import ddo.item.repository.EEffectAliasListRepository;
import ddo.item.repository.ESetRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Base parser good for most item types. It expects that the row has 6 cells:
 *  1 - name
 *  2 - effects
 *  3 - minimum lvl
 *  4 - bind
 *  5 - quest
 *  6 - chest
 */
@Component
@Slf4j
public class BaseEffectParser extends AItemParser {
	
	@Autowired private ESetRepository setRepository;
	@Autowired private EEffectAliasListRepository aliasRepository;
	
	@Value(value = "${item.skippable}")
	private Set<String> skippableItems;
	
	@Value(value = "${item.clickie}")
	private Set<String> clickies;
	
	private Item currentItem;
	
	@Override
	protected Item parseItem(Element row, ItemType type) {
		Elements celle = row.children().select("td");
		if (celle.size() != 6) {
			throw new InvalidRowException(row.text());
		}
		ListIterator<Element> iterator = celle.listIterator();
		int columnIndex = 0;
		while (iterator.hasNext()) {
			Element e = iterator.next();
			switch (columnIndex % 6) {
				case 0 : parseName(e, type); break;
				case 1 : parseEffects(e, type); break;
				case 2 : parseMinimumLevel(e); break;
				case 3 : parseBinding(e); break;
				case 4 : parseQuest(e); break;
				case 5 : parseChest(e); break;
				default : throw new RuntimeException("Caso non previsto!");
			}
			columnIndex += 1;
		}
		return currentItem;
	}
	
	private void parseName(Element e, ItemType slot) {
		// Parso il titolo
		String titolo = e.text();
		for (String skip : skippableItems) {
			if (titolo.contains(skip)) {
				throw new SkipItemException(titolo);
			}
		}
		// Creo il nuovo oggetto sul current e lo aggiungo alla lista
		currentItem = new Item(slot, titolo);		
	}
	
	private void parseEffects(Element e, ItemType type) {
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
			// Verifico se è un set
			if (isSet(effect)) {
				saveSetItem(effect);
			} else if (isAugument(effect)) {
				addAugment(effect);
			} else {
				parseEffect(effect);
			}
		}
	}
	
	private boolean isAugument(String effect) {
		return effect.contains("Augment Slot");
	}
	
	private boolean isSet(String effect) {
		Optional<ESet> oset = setRepository.findById(effect);
		return oset.isPresent();
	}
	
	private void saveSetItem(String setName) {
		NamedSet ns = new NamedSet();
		ns.setName(setName);
		currentItem.addSet(ns);
	}
	
	private void addAugment(String augment) {
		String augmentType = augment.replace("Augment Slot", "").trim();
		augmentType = augmentType.replace(":", "").trim();
		if (augmentType.contains("Slaver")) {
			augmentType = "Green";
		}
		Effect effect = new Effect();
		effect.setName("Augment Slot");
		effect.setType(augmentType);
		effect.setValue(null);
		currentItem.addEffect(effect);
	}
	
	private void parseMinimumLevel(Element e) {
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
	
	private void parseBinding(Element e) {
		// DO NOTHING
	}
	
	private void parseQuest(Element e) {
		// DO NOTHING
	}
	
	private void parseChest(Element e) {
		// DO NOTHING
	}
	
	private void parseEffect(String effectDescription) {
		String bonusType;
		if (effectDescription.matches("Sacred \\+\\d{1,2}")) {
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
		
		// Controllo se è un clickie
		if (bonusType == null && bonusValue == null && clickies.contains(effectDescription)) {
			bonusType = "Clickie";
		}
		
		// Controllo se ho un alias per questo effetto
		List<EEffectAliasList> list = aliasRepository.findByAlias(effectDescription);
		if (list.isEmpty()) {
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
	
	private String parseBonusType(String effectDescription) {
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

}

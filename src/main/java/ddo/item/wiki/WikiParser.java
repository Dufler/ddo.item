package ddo.item.wiki;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ddo.item.entity.EItem;
import ddo.item.entity.EItemEffects;
import ddo.item.model.Effect;
import ddo.item.model.Item;
import ddo.item.model.ItemType;
import ddo.item.repository.EItemEffectsRepository;
import ddo.item.repository.EItemRepository;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WikiParser {
	
	@Autowired private EItemRepository itemRepository;
	@Autowired private EItemEffectsRepository effectsRepository;
	
	private List<Item> items;
	private Item currentItem;
	
	public List<Item> parsePage(String url, ItemType slot) {
		items = new LinkedList<>();
		// recupero la pagina web
		Document doc = getContent(url);
		// parso il contenuto
		Elements tables = doc.select("table");
		ListIterator<Element> iterator = tables.listIterator();
		while (iterator.hasNext()) {
			Element table = iterator.next();
			parseTable(table, slot);
		}		
		// prendo la tabella, per ogni oggetto che trovo creo un modello
		return items;
	}
	
	private void parseTable(Element table, ItemType slot) {
		Elements celle = table.children().select("td");
		ListIterator<Element> iterator = celle.listIterator();
		int columnIndex = 0;
		// 1 - name
		// 2 - effects
		// 3 - minimum lvl
		// 4 - bind
		// 5 - quest
		// 6 - chest
		while (iterator.hasNext()) {
			Element e = iterator.next();
			switch (columnIndex % 6) {
				case 0 : parseName(e, slot); break;
				case 1 : parseEffects(e); break;
				case 2 : parseMinimumLevel(e); break;
				case 3 : parseBinding(e); break;
				case 4 : parseQuest(e); break;
				case 5 : parseChest(e); break;
				default : throw new RuntimeException("Caso non previsto!");
			}
			columnIndex += 1;
		}
	}
	
	private void parseName(Element e, ItemType slot) {
		// Parso il titolo
		String titolo = e.text();
		// Creo il nuovo oggetto sul current e lo aggiungo alla lista
		currentItem = new Item(slot, titolo);
		items.add(currentItem);	
	}
	
	private void parseEffects(Element e) {
		Elements effectsList = e.children().select("> li");
		ListIterator<Element> iterator = effectsList.listIterator();
		while (iterator.hasNext()) {
			Element li = iterator.next();
			String effect;
			try {
				Element span = li.child(0);
				Element anchor = span.child(0);
				effect = anchor.text();
			} catch(Exception exception) {
				effect = String.format("Eccezione: %s html: %s", exception.getMessage(), li.text());
			}
			Effect ef = parseEffect(effect);
			currentItem.addEffect(ef);
		}
	}
	
	private void parseMinimumLevel(Element e) {
		String text = e.text();
		try {
			int ml = Integer.parseInt(text);
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
	
	private Document getContent(String url) {
		try {
			File file = new File(url);
			return Jsoup.parse(file, null);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}
	
	public void saveItems(List<Item> itemList) {
		for (Item item : itemList) {
			log.info(item.toString());
			// Controllo se l'oggetto e' gia' presente nel DB
			List<EItem> items = itemRepository.findByName(item.getName());
			if (items.isEmpty()) {
				save(item);
			} else {
				log.warn(String.format("L'oggetto %s � gi� presente nel DB.", item.getName()));
			}
		}
	}
	
	private Effect parseEffect(String effectDescription) {
		// Parso il tipo di bonus, se presente
		String bonusType = parseBonusType(effectDescription);
		if (bonusType != null) {
			effectDescription = effectDescription.replace(bonusType, "");
		}
		Integer bonusValue = null;
		int index = effectDescription.indexOf('+');
		if (index != -1) {
			String value = effectDescription.substring(index + 1);
			try { bonusValue = Integer.parseInt(value); } catch(Exception e) { log.error(e.getMessage()); }
				effectDescription = effectDescription.substring(0, index);
		}
		effectDescription = effectDescription.trim();
		if (effectDescription.length() > 100) {
			effectDescription = effectDescription.substring(0, 100);
		}
		Effect effect = new Effect();
		effect.setName(effectDescription);
		effect.setType(bonusType);
		effect.setValue(bonusValue);
		return effect;
	}
	
	private void save(Item item) {
		EItem entity = new EItem();
		entity.setName(item.getName());
		entity.setSlot(item.getType());
		itemRepository.save(entity);
		for (Effect e : item.getEffects()) {
			EItemEffects effect = new EItemEffects();
			effect.setItemId(entity.getId());
			effect.setEffect(e.getName());
			effect.setType(e.getType());
			effect.setValue(e.getValue());
			effectsRepository.save(effect);
		}
	}
	
	private String parseBonusType(String effectDescription) {
		String type = null;
		if (effectDescription.contains("Insightful")) {
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

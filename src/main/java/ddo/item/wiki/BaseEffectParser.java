package ddo.item.wiki;

import java.util.ListIterator;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import ddo.item.model.Effect;
import ddo.item.model.Item;
import ddo.item.model.ItemType;
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
		return null;
	}
	
	private void parseName(Element e, ItemType slot) {
		// Parso il titolo
		String titolo = e.text();
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

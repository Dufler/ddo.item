package ddo.item.wiki;

import java.util.ListIterator;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import ddo.item.model.Item;
import ddo.item.model.ItemType;

@Component
public class ShieldEffectParser extends AItemParser {

	@Override
	protected Item parseItem(Element row, ItemType type) {
		Elements celle = row.children().select("td");
		if (celle.size() != 13) {
			throw new InvalidRowException(row.text());
		}
		ListIterator<Element> iterator = celle.listIterator();
		int columnIndex = 0;
		while (iterator.hasNext()) {
			Element e = iterator.next();
			switch (columnIndex % 13) {
				case 0 : parseName(e, type); break;
				case 1 : parseEffects(e, type); break;
				case 2 : parseMinimumLevel(e); break;
				case 3 : parseArmorClass(e); break;
				case 4 : parseMaxDexterityBonus(e); break;
				case 5 : parseDamageReduction(e); break;
				case 6 : parseArmorCheckPenality(e); break;
				case 7 : parseArcaneSpellFailure(e); break;
				case 8 : parseMaterial(e); break;
				case 9 : parseDamage(e); break;
				case 10 : parseCriticalRoll(e); break;
				case 11 : parseBinding(e); break;
				case 12 : parseQuest(e); break;
				default : throw new RuntimeException("Caso non previsto!");
			}
			columnIndex += 1;
		}
		return currentItem;
	}
	
	private void parseArmorClass(Element e) {
		
	}
	
	private void parseMaxDexterityBonus(Element e) {
		
	}
	
	private void parseDamageReduction(Element e) {
		
	}
	
	private void parseArmorCheckPenality(Element e) {
		
	}
	
	private void parseArcaneSpellFailure(Element e) {
		
	}
	
	private void parseMaterial(Element e) {
		
	}
	
	private void parseDamage(Element e) {
		
	}
	
	private void parseCriticalRoll(Element e) {
		
	}

}

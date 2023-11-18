package ddo.item.wiki;

import java.util.ListIterator;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import ddo.item.model.Item;
import ddo.item.model.ItemType;

@Component
public class WeaponEffectParser extends AItemParser {
	
	@Override
	protected Item parseItem(Element row, ItemType type) {
		Elements celle = row.children().select("td");
		if (celle.size() != 7) {
			throw new InvalidRowException(row.text());
		}
		ListIterator<Element> iterator = celle.listIterator();
		int columnIndex = 0;
		while (iterator.hasNext()) {
			Element e = iterator.next();
			switch (columnIndex % 7) {
				case 0 : parseName(e, type); break;
				case 1 : parseEffects(e, type); break;
				case 2 : parseMinimumLevel(e); break;
				case 3 : parseDamage(e); break;
				case 4 : parseBinding(e); break;
				case 5 : parseQuest(e); break;
				case 6 : parseUnusualCaratteristics(e); break;
				default : throw new RuntimeException("Caso non previsto!");
			}
			columnIndex += 1;
		}
		return currentItem;
	}
	
	private void parseDamage(Element e) {
		// DO NOTHING!
	}
	
	private void parseUnusualCaratteristics(Element e) {
		// DO NOTHING!
	}

}

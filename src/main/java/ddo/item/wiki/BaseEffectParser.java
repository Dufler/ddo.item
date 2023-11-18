package ddo.item.wiki;

import java.util.ListIterator;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import ddo.item.model.Item;
import ddo.item.model.ItemType;

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
public class BaseEffectParser extends AItemParser {
	
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

}

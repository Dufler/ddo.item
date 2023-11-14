package ddo.item.wiki;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;

import ddo.item.model.Item;
import ddo.item.model.ItemType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AItemParser {

	public List<Item> parseRows(List<Element> rows, ItemType type) {
		ArrayList<Item> itemList = new ArrayList<>();
		for (Element row : rows) {
			try {
				Item item = parseItem(row, type);
				itemList.add(item);
			} catch(InvalidRowException e) {
				log.error(e.getMessage());
			} catch(SkipItemException e) {
				log.error(String.format("Skipped: %s", e.getMessage()));
			}
		}
		return itemList;
	}
	
	protected abstract Item parseItem(Element row, ItemType type);
	
}

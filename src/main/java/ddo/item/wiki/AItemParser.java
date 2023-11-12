package ddo.item.wiki;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;

import ddo.item.model.Item;
import ddo.item.model.ItemType;

public abstract class AItemParser {

	public List<Item> parseRows(List<Element> rows, ItemType type) {
		ArrayList<Item> itemList = new ArrayList<>();
		for (Element row : rows) {
			Item item = parseItem(row, type);
			itemList.add(item);
		}
		return itemList;
	}
	
	protected abstract Item parseItem(Element row, ItemType type);
	
}

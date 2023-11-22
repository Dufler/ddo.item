package test.ddo.item.util;

import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import ddo.item.model.Item;
import ddo.item.model.ItemType;
import ddo.item.wiki.AItemParser;


@Component
public class TestItemParser extends AItemParser {

	@Override
	protected Item parseItem(Element row, ItemType type) {
		// DO NOTHING! - Non serve ai fini del test
		return null;
	}
	
	public Item getParsedItem() {
		return currentItem;
	}
	
	/**
	 * Rendo il metodo public per poterlo testare.
	 */
	public void parseEffect(String name, ItemType type, String effectDescription) {
		currentItem = new Item(type, name);
		super.parseEffect(effectDescription);
	}

}

package test.ddo.item.parse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ddo.item.model.ItemType;
import ddo.item.wiki.WikiParser;

public class ArmorParseTest {
	
	@Autowired private WikiParser wp;
	
	@Test
	public void parseLightArmor() {
		ItemType type = ItemType.ARMOR_LIGHT;
		String resource = String.format("src/main/resources/pages/%s.html", type.name().toLowerCase());
		wp.updateItems(resource, type);
	}

}

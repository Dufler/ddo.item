package test.ddo.item.parse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ddo.item.entity.EItem;
import ddo.item.model.ItemType;
import ddo.item.repository.EItemRepository;
import ddo.item.wiki.WikiParser;
import test.ddo.item.TestConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = TestConfiguration.class)
public class ArmorParseTest {
	
	@Autowired private EItemRepository itemRepository;
	@Autowired private WikiParser wp;
	
	@Test
	public void parseLightArmor() {
		// Verifico che non ci siano ancora oggetti nel DB
		List<EItem> items = itemRepository.findAll();
		assertTrue(items.isEmpty());
		ItemType type = ItemType.ARMOR_LIGHT;
		String resource = String.format("src/main/resources/pages/%s.html", type.name().toLowerCase());
		wp.updateItems(resource, type);
		items = itemRepository.findAll();
		assertEquals(100, items.size());
	}

}

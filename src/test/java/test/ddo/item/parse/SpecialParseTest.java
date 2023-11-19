package test.ddo.item.parse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import ddo.item.entity.EItem;
import ddo.item.model.ItemType;
import ddo.item.repository.EItemRepository;
import ddo.item.wiki.WikiParser;
import test.ddo.item.TestConfiguration;

@SpringBootTest(classes = TestConfiguration.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class SpecialParseTest {
	
	@Autowired private EItemRepository itemRepository;
	@Autowired private WikiParser wp;
	
	@Test
	public void parseOrbs() {
		// Verifico che non ci siano ancora oggetti nel DB
		List<EItem> items = itemRepository.findAll();
		assertTrue(items.isEmpty());
		ItemType type = ItemType.ORB;
		String resource = String.format("src/main/resources/pages/%s.html", type.name().toLowerCase());
		wp.updateItems(resource, type);
		items = itemRepository.findAll();
		assertEquals(95, items.size());
	}
	
	@Test
	public void parseRuneArm() {
		// Verifico che non ci siano ancora oggetti nel DB
		List<EItem> items = itemRepository.findAll();
		assertTrue(items.isEmpty());
		ItemType type = ItemType.RUNEARM;
		String resource = String.format("src/main/resources/pages/%s.html", type.name().toLowerCase());
		wp.updateItems(resource, type);
		items = itemRepository.findAll();
		assertEquals(114, items.size());
	}

}

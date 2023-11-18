package test.ddo.item.parse;

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
import lombok.extern.slf4j.Slf4j;
import test.ddo.item.TestConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = TestConfiguration.class)
@Slf4j
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ArmorParseTest {
	
	@Autowired private EItemRepository itemRepository;
	@Autowired private WikiParser wp;
	
	@Test
	public void parseHeavyArmor() {
		// Verifico che non ci siano ancora oggetti nel DB
		List<EItem> items = itemRepository.findAll();
		assertTrue(items.isEmpty());
		ItemType type = ItemType.ARMOR_HEAVY;
		String resource = String.format("src/main/resources/pages/%s.html", type.name().toLowerCase());
		wp.updateItems(resource, type);
		items = itemRepository.findAll();
		assertEquals(156, items.size());
	}
	
	@Test
	public void parseMediumArmor() {
		// Verifico che non ci siano ancora oggetti nel DB
		List<EItem> items = itemRepository.findAll();
		assertTrue(items.isEmpty());
		ItemType type = ItemType.ARMOR_MEDIUM;
		String resource = String.format("src/main/resources/pages/%s.html", type.name().toLowerCase());
		wp.updateItems(resource, type);
		items = itemRepository.findAll();
		assertEquals(143, items.size());
	}
	
	@Test
	public void parseLightArmor() {
		// Verifico che non ci siano ancora oggetti nel DB
		List<EItem> items = itemRepository.findAll();
		assertTrue(items.isEmpty());
		ItemType type = ItemType.ARMOR_LIGHT;
		String resource = String.format("src/main/resources/pages/%s.html", type.name().toLowerCase());
		wp.updateItems(resource, type);
		items = itemRepository.findAll();
		assertEquals(196, items.size());
	}
	
	@Test
	public void parseClothArmor() {
		// Verifico che non ci siano ancora oggetti nel DB
		List<EItem> items = itemRepository.findAll();
		assertTrue(items.isEmpty());
		ItemType type = ItemType.ARMOR_CLOTH;
		String resource = String.format("src/main/resources/pages/%s.html", type.name().toLowerCase());
		wp.updateItems(resource, type);
		items = itemRepository.findAll();
		for (EItem i : items) {
			log.info(i.toString());
		}
		assertEquals(181, items.size());
	}

}

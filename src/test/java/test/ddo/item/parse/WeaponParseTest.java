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
public class WeaponParseTest {
	
	@Autowired private EItemRepository itemRepository;
	@Autowired private WikiParser wp;
	
	@Test
	public void parseDagger() {
		// Verifico che non ci siano ancora oggetti nel DB
		List<EItem> items = itemRepository.findAll();
		assertTrue(items.isEmpty());
		ItemType type = ItemType.DAGGER;
		String resource = String.format("src/main/resources/pages/%s.html", type.name().toLowerCase());
		wp.updateItems(resource, type);
		items = itemRepository.findAll();
		assertEquals(151, items.size());
	}
	
	@Test
	public void parseKukri() {
		// Verifico che non ci siano ancora oggetti nel DB
		List<EItem> items = itemRepository.findAll();
		assertTrue(items.isEmpty());
		ItemType type = ItemType.KUKRI;
		String resource = String.format("src/main/resources/pages/%s.html", type.name().toLowerCase());
		wp.updateItems(resource, type);
		items = itemRepository.findAll();
		assertEquals(53, items.size());
	}
	
	@Test
	public void parseGreatsword() {
		// Verifico che non ci siano ancora oggetti nel DB
		List<EItem> items = itemRepository.findAll();
		assertTrue(items.isEmpty());
		ItemType type = ItemType.GREATSWORD;
		String resource = String.format("src/main/resources/pages/%s.html", type.name().toLowerCase());
		wp.updateItems(resource, type);
		items = itemRepository.findAll();
		assertEquals(87, items.size());
	}
	
	@Test
	public void parseHandwraps() {
		// Verifico che non ci siano ancora oggetti nel DB
		List<EItem> items = itemRepository.findAll();
		assertTrue(items.isEmpty());
		ItemType type = ItemType.HANDWRAPS;
		String resource = String.format("src/main/resources/pages/%s.html", type.name().toLowerCase());
		wp.updateItems(resource, type);
		items = itemRepository.findAll();
		assertEquals(119, items.size());
	}
	
	@Test
	public void parseThrowingDagger() {
		// Verifico che non ci siano ancora oggetti nel DB
		List<EItem> items = itemRepository.findAll();
		assertTrue(items.isEmpty());
		ItemType type = ItemType.THROWINGDAGGER;
		String resource = String.format("src/main/resources/pages/%s.html", type.name().toLowerCase());
		wp.updateItems(resource, type);
		items = itemRepository.findAll();
		assertEquals(46, items.size());
	}

}

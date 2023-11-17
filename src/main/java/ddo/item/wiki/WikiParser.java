package ddo.item.wiki;

import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import javax.transaction.Transactional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ddo.item.entity.EItem;
import ddo.item.entity.EItemEffects;
import ddo.item.model.Effect;
import ddo.item.model.Item;
import ddo.item.model.ItemType;
import ddo.item.model.NamedSet;
import ddo.item.repository.EItemEffectsRepository;
import ddo.item.repository.EItemRepository;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WikiParser {
	
	@Autowired private EItemRepository itemRepository;
	@Autowired private EItemEffectsRepository effectsRepository;
	
	@Autowired private BaseEffectParser baseParser;
	
	private List<Item> items;
	
	@Transactional
	public void updateItems(String url, ItemType slot) {
		items = new LinkedList<>();
		// let's get the web page
		Document doc = getContent(url);
		// parse the content, let's focus on tables
		Elements tables = doc.select("table");
		ListIterator<Element> iterator = tables.listIterator();
		while (iterator.hasNext()) {
			Element table = iterator.next();
			parseTable(table, slot);
		}		
		// Save the result
		saveItems();
	}
	
	private void parseTable(Element table, ItemType type) {
		Elements rows = table.children().select("tr");
		switch (type) {
			default : items = baseParser.parseRows(rows, type); break;
		}
		log.info(String.format("Trovati %d oggetti per la categoria %s", items.size(), type));
	}
	
	private Document getContent(String url) {
		try {
			File file = new File(url);
			return Jsoup.parse(file, null);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}
	
	private void saveItems() {
		for (Item item : items) {
			log.info(item.toString());
			save(item);
		}
	}
	
	private void save(Item item) {
		EItem entity = new EItem();
		entity.setName(item.getName());
		entity.setSlot(item.getType());
		entity.setMinimumLevel(item.getMinimumLevel());
		Set<String> sets = new HashSet<>();
		for (NamedSet ns :item.getSets()) {
			sets.add(ns.getName());
		}
		entity.setSets(sets);
		itemRepository.save(entity);
		for (Effect e : item.getEffects()) {
			EItemEffects effect = new EItemEffects();
			effect.setItemName(item.getName());
			effect.setEffect(e.getName());
			effect.setType(e.getType());
			effect.setValue(e.getValue());
			effectsRepository.save(effect);
		}
	}

}

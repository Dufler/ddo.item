package ddo.item.wiki;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;

import ddo.item.entity.EItem;
import ddo.item.model.Item;
import ddo.item.model.ItemType;
import ddo.item.repository.EItemRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AItemParser {
	
	@Autowired private EItemRepository itemRepository;

	public List<Item> parseRows(List<Element> rows, ItemType type) {
		ArrayList<Item> itemList = new ArrayList<>();
		for (Element row : rows) {
			try {
				Item item = parseItem(row, type);
				// Verifico se è già presente
				Optional<EItem> match = itemRepository.findById(item.getName());
				if (match.isEmpty()) {
					itemList.add(item);
				}
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

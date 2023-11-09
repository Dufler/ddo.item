package ddo.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ddo.item.entity.EItem;
import ddo.item.entity.EItemEffects;
import ddo.item.gui.SWTFrame;
import ddo.item.model.Item;
import ddo.item.model.ItemType;
import ddo.item.repository.EItemEffectsRepository;
import ddo.item.repository.EItemRepository;
import ddo.item.wiki.WikiParser;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@ComponentScan({
	"ddo.item.wiki",
	"ddo.item.gui",
	"ddo.item.logic"
})
@EnableJpaRepositories(basePackages = "ddo.item.repository")
@EntityScan("ddo.item.entity")
@Slf4j
public class Main implements CommandLineRunner {
	
//	@Autowired private Frame frame;
	@Autowired private SWTFrame frame;
	
	@Autowired private WikiParser wp;
	@Autowired private EItemRepository itemRepository;
	@Autowired private EItemEffectsRepository effectsRepository;

	public static void main(String[] args) {
        log.info("STARTING THE APPLICATION");
//        SpringApplication.run(Main.class, args);
        new SpringApplicationBuilder(Main.class).headless(false).run(args);
        log.info("APPLICATION FINISHED");
    }
 
    @Override
    public void run(String... args) {
    	frame.open();
    }
	
	private void parseItems() {
		log.info("Parsing degli oggetti");
		for (ItemType slot : ItemType.values()) {
			String resource = String.format("src/main/resources/pages/%s.html", slot.name().toLowerCase());
			List<Item> itemList = wp.parsePage(resource, slot);
			log.info(String.format("Trovati %d oggetti per la categoria %s", itemList.size(), slot));
			saveItems(itemList);
		}		
	}
	
	private void saveItems(List<Item> itemList) {
		for (Item item : itemList) {
			log.info(item.toString());
			// Controllo se l'oggetto e' gia' presente nel DB
			List<EItem> items = itemRepository.findByName(item.getName());
			if (items.isEmpty()) {
				save(item);
			} else {
				log.warn(String.format("L'oggetto %s � gi� presente nel DB.", item.getName()));
			}
		}
	}
	
	private void save(Item item) {
		EItem entity = new EItem();
		entity.setName(item.getName());
		entity.setSlot(item.getSlot());
		itemRepository.save(entity);
		for (String effectDescription : item.getEffects()) {
			// Parso il tipo di bonus, se presente
			String bonusType = parseBonusType(effectDescription);
			if (bonusType != null) {
				effectDescription = effectDescription.replace(bonusType, "");
			}
			Integer bonusValue = null;
			int index = effectDescription.indexOf('+');
			if (index != -1) {
				String value = effectDescription.substring(index + 1);
				try { bonusValue = Integer.parseInt(value); } catch(Exception e) { log.error(e.getMessage()); }
				effectDescription = effectDescription.substring(0, index);
			}
			effectDescription = effectDescription.trim();
			if (effectDescription.length() > 100) {
				effectDescription = effectDescription.substring(0, 100);
			}
			EItemEffects effect = new EItemEffects();
			effect.setItemId(entity.getId());
			effect.setEffect(effectDescription);
			effect.setType(bonusType);
			effect.setValue(bonusValue);
			effectsRepository.save(effect);
		}
	}
	
	private String parseBonusType(String effectDescription) {
		String type = null;
		if (effectDescription.contains("Insightful")) {
			type = "Insightful";
		}
		if (effectDescription.contains("Quality")) {
			type = "Quality";
		}
		if (effectDescription.contains("Profane")) {
			type = "Profane";
		}
		if (effectDescription.contains("Sacred")) {
			type = "Sacred";
		}
		return type;
	}

}

package ddo.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ddo.item.gui.SWTFrame;
import ddo.item.model.Item;
import ddo.item.model.ItemType;
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
	
	@Autowired private SWTFrame frame;
	
	@Autowired private WikiParser wp;
	
	public static void main(String[] args) {
        log.info("STARTING THE APPLICATION");
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
			wp.saveItems(itemList);
		}		
	}
	
	

}

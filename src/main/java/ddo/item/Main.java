package ddo.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ddo.item.gui.SWTFrame;
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
		
	public static void main(String[] args) {
        log.info("STARTING THE APPLICATION");
        new SpringApplicationBuilder(Main.class).headless(false).run(args);
        log.info("APPLICATION FINISHED");
    }
 
    @Override
    public void run(String... args) {
    	frame.open();
    }	

}

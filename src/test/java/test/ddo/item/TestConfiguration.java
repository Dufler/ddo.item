package test.ddo.item;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({
	"ddo.item.wiki",
	"ddo.item.logic"
})
@EnableJpaRepositories(basePackages = "ddo.item.repository")
@EntityScan("ddo.item.entity")
public class TestConfiguration {

}

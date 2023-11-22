package test.ddo.item.parse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import ddo.item.model.Effect;
import ddo.item.model.Item;
import ddo.item.model.ItemType;
import test.ddo.item.TestConfiguration;
import test.ddo.item.util.TestItemParser;

@SpringBootTest(classes = TestConfiguration.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ParserTest {
	
	@Autowired private TestItemParser parser;
	
	@Test
	public void parseExceptionalSkills() {
		String effect = "Exceptional Nimble Skills Bonus +10";
		parser.parseEffect("Legendary Tumbleweed", ItemType.RING, effect);
		Item i = parser.getParsedItem();
		List<Effect> effectList = i.getEffects();
		assertEquals(1, effectList.size());
		Effect e = effectList.get(0);
		assertEquals("Dexterity Skills", e.getName());
		assertEquals("Exceptional", e.getType());
		assertEquals(10, e.getValue());
	}

}

package test.ddo.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;

import ddo.item.gui.effects.SelectedEffect;
import ddo.item.model.BodySlot;
import ddo.item.model.Item;
import test.ddo.item.util.EquippedItemsTester;

@SpringBootTest(classes = TestConfiguration.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class EquipItemsTest {
	
	@Autowired private EquippedItemsTester manager;
	
	private Map<String, SelectedEffect> effects;
	
	@Test
	public void testEquipSetItem() {
		// Recupero i 2 oggetti del set che voglio testare
		Item bracers = manager.getItem("Legendary Bracers of the Claw");
		assertNotNull(bracers);
		Item gloves = manager.getItem("Legendary Gloves of the Claw");
		assertNotNull(gloves);
		// Li equipaggio
		manager.equip(BodySlot.WRIST, bracers);
		manager.equip(BodySlot.HANDS, gloves);		
		// Verifico che tutti i bonus vengano applicati, compreso il set
		effects = manager.getSelectedEffects();
		assertEffectTotal("Deadly", 3);
		assertEffectType("Deadly", "Artifact", 1);	
	}
	
	private void assertEffectTotal(String name, int total) {
		SelectedEffect effect = effects.get(name);
		assertNotNull(effect);
		assertEquals(total, effect.getTotalBonus());
	}
	
	private void assertEffectType(String name, String type, int bonus) {
		SelectedEffect effect = effects.get(name);
		assertNotNull(effect);
		Map<String, Integer> types = effect.getBonuses();
		assertEquals(bonus, types.get(type));
	}

}

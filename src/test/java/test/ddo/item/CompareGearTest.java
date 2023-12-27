package test.ddo.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Collection;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;

import ddo.item.gui.effects.CompareSelectedEffect;
import ddo.item.logic.EquippedItems;
import ddo.item.model.GearSetup;
import test.ddo.item.util.ComparisonManagerTester;

@SpringBootTest(classes = TestConfiguration.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class CompareGearTest {
	
	@Autowired private EquippedItems setupManager;
	@Autowired private ComparisonManagerTester manager;
	
	private Map<String, CompareSelectedEffect> effects;
	
	@Test
	public void compare() {
		// Carico i 2 setup
		Collection<GearSetup> setups = setupManager.getAllSetups();
		GearSetup first = findById(setups, 104);
		assertNotNull(first);
		GearSetup second = findById(setups, 103);
		assertNotNull(second);
		// Inserisco il primo setup
		manager.loadFirstGearSetup(first);
		// Verifico che tutti i bonus vengano applicati, compreso il set
		effects = manager.getSelectedEffects();
		assertEffectTotal("Melee Power", 42, 0);
		assertEffectType("Melee Power", "Artifact", 15, null);
		// Inserisco il secondo setup
		manager.loadSecondGearSetup(second);
		assertEffectTotal("Melee Power", 42, 30);
		assertEffectType("Melee Power", "Artifact", 15, 15);	
	}
	
	private GearSetup findById(Collection<GearSetup> setups, Integer id) {
		GearSetup setup = null;
		for (GearSetup gs : setups) {
			if (gs.getId() == id) {
				setup = gs;
				break;
			}
		}
		return setup;
	}
	
	private void assertEffectTotal(String name, Integer totalFirst, Integer totalSecond) {
		CompareSelectedEffect effect = effects.get(name);
		assertNotNull(effect, String.format("%s is missing", name));
		assertEquals(totalFirst, effect.getTotalBonusFirst(), String.format("total first %s (%d vs %d)", name, totalFirst, effect.getTotalBonusFirst()));
		assertEquals(totalSecond, effect.getTotalBonusSecond(), String.format("total second %s (%d vs %d)", name, totalSecond, effect.getTotalBonusSecond()));
	}
	
	private void assertEffectType(String name, String type, Integer totalFirst, Integer totalSecond) {
		CompareSelectedEffect effect = effects.get(name);
		assertNotNull(effect, String.format("%s is missing", name));
		Map<String, Integer> typesFirst = effect.getBonusesFirst();
		assertEquals(totalFirst, typesFirst.get(type), String.format("first %s - %s (%d vs %d)", name, type, totalFirst, typesFirst.get(type)));
		Map<String, Integer> typesSecond = effect.getBonusesSecond();
		assertEquals(totalSecond, typesSecond.get(type), String.format("second %s - %s (%d vs %d)", name, type, totalSecond, typesSecond.get(type)));
	}

}

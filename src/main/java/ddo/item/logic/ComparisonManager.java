package ddo.item.logic;

import java.util.List;

import org.springframework.stereotype.Component;

import ddo.item.entity.EGearSetupAugment;
import ddo.item.entity.EGearSetupItem;
import ddo.item.gui.effects.TabellaCompareEffects;
import ddo.item.model.Augment;
import ddo.item.model.AugmentSlot;
import ddo.item.model.GearSetup;
import ddo.item.model.Item;

@Component
public class ComparisonManager extends EquippedItems {
	
	private TabellaCompareEffects tabella;
	
	public void setTabella(TabellaCompareEffects t) {
		tabella = t;
	}
	
	public void refreshTables() {
		tabella.setElementi(selectedEffects.values());
	}
	
	public void loadGearSetup(GearSetup gs) {
		setup = gs;
		List<EGearSetupItem> itemList = repositorySetupItem.findByIdSetup(setup.getId());
		equippedItems = setup.getItems();
		for (EGearSetupItem item : itemList) {
			List<EGearSetupAugment> augmentList = repositorySetupAugment.findByIdSetupAndItem(setup.getId(), item.getItem());
			Item i = items.get(item.getItem());
			if (i != null) for (AugmentSlot as : i.getAugments()) {
				for (EGearSetupAugment a : augmentList) {
					if (as.getType().equals(a.getAugmentType()) && a.getAugment() != null) {
						Augment augment = AugmentManager.getInstance().getByName(a.getAugment());
						as.setAugment(augment);
					}
				}
			}
			equippedItems.put(item.getSlot(), i);
		}
		updateSelectedEffects();
	}

}

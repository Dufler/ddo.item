package ddo.item.logic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ddo.item.entity.EGearSetupAugment;
import ddo.item.entity.EGearSetupItem;
import ddo.item.gui.effects.SelectedEffect;
import ddo.item.gui.effects.TabellaCompareEffects;
import ddo.item.gui.set.SelectedSet;
import ddo.item.model.Augment;
import ddo.item.model.AugmentSlot;
import ddo.item.model.BodySlot;
import ddo.item.model.Effect;
import ddo.item.model.GearSetup;
import ddo.item.model.Item;
import ddo.item.repository.EGearSetupAugmentRepository;
import ddo.item.repository.EGearSetupItemRepository;

@Component
@Scope("prototype")
public class ComparisonManager {
	
	@Autowired private EGearSetupItemRepository repositorySetupItem;
	@Autowired private EGearSetupAugmentRepository repositorySetupAugment;
	
	private TabellaCompareEffects tabella;
	
	private GearSetup setup;
	private Map<BodySlot, Item> equippedItems;
	private Map<String, SelectedEffect> selectedEffects;
	
	public ComparisonManager() {
		
		selectedEffects = new HashMap<>();
	}
	
	public void setTabella(TabellaCompareEffects t) {
		tabella = t;
	}
	
	public void refreshTables() {
		tabella.setElementi(selectedEffects.values());
	}
	
	public void loadGearSetup(GearSetup gs) {
		setup = gs;
		equippedItems = setup.getItems();
		for (BodySlot slot : BodySlot.values()) {
			equippedItems.put(slot, null);
		}
		List<EGearSetupItem> itemList = repositorySetupItem.findByIdSetup(setup.getId());
		equippedItems = setup.getItems();
		for (EGearSetupItem item : itemList) {
			List<EGearSetupAugment> augmentList = repositorySetupAugment.findByIdSetupAndItem(setup.getId(), item.getItem());
			Item i = EquippedItems.getInstance().getItem(item.getItem());
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
	
	public void updateSelectedEffects() {
		// Aggiorno i set
		SetManager.getInstance().updateSelectedSet();
		// resetto la mappa degli effetti lasciando solo quelli selezionati dall'utente
		clearEffectsNotSelectedbyUser();
		// per ogni oggetto inserisco gli effetti
		for (BodySlot slot : equippedItems.keySet()) {
			// Se c'è un oggetto equipaggiato nello slot ne aggiungo gli effetti
			Item item = equippedItems.get(slot);
			if (item != null) {
				// Aggiungo gli effetti propri dell'oggetto
				for (Effect e : item.getEffects()) {
					addEffect(e);
				}
				// Aggiungo gli effetti degli augment, se presenti
				for (AugmentSlot a : item.getAugments()) {
					if (a.getAugment() != null) for (Effect f : a.getAugment().getEffects()) {
						addEffect(f);
					}
				}
			}
		}
		// per ogni set completo inserisco gli effetti
		Map<String, SelectedSet> setMap = SetManager.getInstance().getSelectedSet();
		for (SelectedSet ss : setMap.values()) {
			// se ho abbastanza pezzi aggiungo gli effetti del set
			if (ss.getActualNumberOfPieces() >= ss.getMaxNumberOfPieces()) {
				for (Effect e : ss.getEffects()) {
					addEffect(e);
				}
			}
		}
		// refresho le tabelle
		refreshTables();
	}
	
	private void clearEffectsNotSelectedbyUser() {
		Iterator<Entry<String, SelectedEffect>> iterator = selectedEffects.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, SelectedEffect> entry = iterator.next();
			SelectedEffect se = entry.getValue();
			if (!se.isUserSelected()) {
				iterator.remove();
			} else {
				// resetto i bonus che poi ricalcolerò
				se.getBonuses().clear();
			}
		}
	}
	
	private void addEffect(Effect e) {
		if (e.getType() != null && e.getType().equalsIgnoreCase("Clickie")) {
			// TODO - Aggiungi il clikie alla lista
		} else {
			if (!selectedEffects.containsKey(e.getName())) {
				SelectedEffect se = new SelectedEffect();
				se.setName(e.getName());
				se.setUserSelected(false);
				selectedEffects.put(e.getName(), se);
			}
			SelectedEffect se = selectedEffects.get(e.getName());
			Map<String, Integer> mappaBonus = se.getBonuses();
			Integer actualValue = mappaBonus.get(e.getType());
			if (actualValue == null || actualValue < e.getValue()) {
				mappaBonus.put(e.getType(), e.getValue());
			}
		}		
	}

}

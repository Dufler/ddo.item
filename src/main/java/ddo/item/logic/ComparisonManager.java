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
import ddo.item.gui.effects.CompareSelectedEffect;
import ddo.item.gui.effects.TabellaCompareEffects;
import ddo.item.gui.set.SelectedSet;
import ddo.item.model.Augment;
import ddo.item.model.AugmentSlot;
import ddo.item.model.BaseEffect;
import ddo.item.model.BodySlot;
import ddo.item.model.Effect;
import ddo.item.model.GearSetup;
import ddo.item.model.Item;
import ddo.item.model.NamedSet;
import ddo.item.repository.EGearSetupAugmentRepository;
import ddo.item.repository.EGearSetupItemRepository;
import lombok.extern.slf4j.Slf4j;

@Component
@Scope("prototype")
@Slf4j
public class ComparisonManager {
	
	@Autowired private EGearSetupItemRepository repositorySetupItem;
	@Autowired private EGearSetupAugmentRepository repositorySetupAugment;
	
	private TabellaCompareEffects tabella;
	
	private GearSetup firstSetup;
	private GearSetup secondSetup;
	
	private Map<BodySlot, Item> firstEquippedItems;
	private Map<BodySlot, Item> secondEquippedItems;
	
	private final HashMap<String, SelectedSet> firstSelectedSets;
	private final HashMap<String, SelectedSet> secondSelectedSets;
	
	private Map<String, CompareSelectedEffect> selectedEffects;
	
	public ComparisonManager() {
		selectedEffects = new HashMap<>();
		firstSelectedSets = new HashMap<>();
		secondSelectedSets = new HashMap<>();
		firstEquippedItems = new HashMap<>();
		for (BodySlot slot : BodySlot.values()) {
			firstEquippedItems.put(slot, null);
		}
		secondEquippedItems = new HashMap<>();
		for (BodySlot slot : BodySlot.values()) {
			secondEquippedItems.put(slot, null);
		}
	}
	
	public void setTabella(TabellaCompareEffects t) {
		tabella = t;
	}
	
	public void refreshTables() {
		tabella.setElementi(selectedEffects.values());
	}
	
	public void loadFirstGearSetup(GearSetup gs) {
		firstSetup = gs;
		firstEquippedItems = firstSetup.getItems();
		for (BodySlot slot : BodySlot.values()) {
			firstEquippedItems.put(slot, null);
		}
		List<EGearSetupItem> itemList = repositorySetupItem.findByIdSetup(firstSetup.getId());
		firstEquippedItems = firstSetup.getItems();
		for (EGearSetupItem item : itemList) {
			List<EGearSetupAugment> augmentList = repositorySetupAugment.findByIdSetupAndItem(firstSetup.getId(), item.getItem());
			Item i = EquippedItems.getInstance().getItem(item.getItem());
			if (i != null) for (AugmentSlot as : i.getAugments()) {
				for (EGearSetupAugment a : augmentList) {
					if (as.getType().equals(a.getAugmentType()) && a.getAugment() != null) {
						Augment augment = AugmentManager.getInstance().getByName(a.getAugment());
						as.setAugment(augment);
					}
				}
			}
			firstEquippedItems.put(item.getSlot(), i);
		}
		updateSelectedEffects();
	}
	
	public void loadSecondGearSetup(GearSetup gs) {
		secondSetup = gs;
		secondEquippedItems = secondSetup.getItems();
		for (BodySlot slot : BodySlot.values()) {
			secondEquippedItems.put(slot, null);
		}
		List<EGearSetupItem> itemList = repositorySetupItem.findByIdSetup(secondSetup.getId());
		secondEquippedItems = secondSetup.getItems();
		for (EGearSetupItem item : itemList) {
			List<EGearSetupAugment> augmentList = repositorySetupAugment.findByIdSetupAndItem(secondSetup.getId(), item.getItem());
			Item i = EquippedItems.getInstance().getItem(item.getItem());
			if (i != null) for (AugmentSlot as : i.getAugments()) {
				for (EGearSetupAugment a : augmentList) {
					if (as.getType().equals(a.getAugmentType()) && a.getAugment() != null) {
						Augment augment = AugmentManager.getInstance().getByName(a.getAugment());
						as.setAugment(augment);
					}
				}
			}
			secondEquippedItems.put(item.getSlot(), i);
		}
		updateSelectedEffects();
	}
	
	public void updateSelectedEffects() {
		// Aggiorno i set
		updateFirstSelectedSet();
		updateSecondSelectedSet();
		// resetto la mappa degli effetti lasciando solo quelli selezionati dall'utente
		clearEffectsNotSelectedbyUser();
		// per ogni oggetto inserisco gli effetti
		for (Item item : firstEquippedItems.values()) {
			// Se c'è un oggetto equipaggiato nello slot ne aggiungo gli effetti
			if (item != null) {
				// Aggiungo gli effetti propri dell'oggetto
				for (Effect e : item.getEffects()) {
					addEffectFirst(e);
				}
				// Aggiungo gli effetti degli augment, se presenti
				for (AugmentSlot a : item.getAugments()) {
					if (a.getAugment() != null) for (Effect f : a.getAugment().getEffects()) {
						addEffectFirst(f);
					}
				}
			}
		}
		for (Item item : secondEquippedItems.values()) {
			// Se c'è un oggetto equipaggiato nello slot ne aggiungo gli effetti
			if (item != null) {
				// Aggiungo gli effetti propri dell'oggetto
				for (Effect e : item.getEffects()) {
					addEffectSecond(e);
				}
				// Aggiungo gli effetti degli augment, se presenti
				for (AugmentSlot a : item.getAugments()) {
					if (a.getAugment() != null) for (Effect f : a.getAugment().getEffects()) {
						addEffectSecond(f);
					}
				}
			}
		}
		// per ogni set completo inserisco gli effetti
		for (SelectedSet ss : firstSelectedSets.values()) {
			// se ho abbastanza pezzi aggiungo gli effetti del set
			if (ss.getActualNumberOfPieces() >= ss.getMaxNumberOfPieces()) {
				for (Effect e : ss.getEffects()) {
					addEffectFirst(e);
				}
			}
		}
		for (SelectedSet ss : secondSelectedSets.values()) {
			// se ho abbastanza pezzi aggiungo gli effetti del set
			if (ss.getActualNumberOfPieces() >= ss.getMaxNumberOfPieces()) {
				for (Effect e : ss.getEffects()) {
					addEffectSecond(e);
				}
			}
		}
		// refresho le tabelle
		refreshTables();
	}
	
	private void clearEffectsNotSelectedbyUser() {
		Iterator<Entry<String, CompareSelectedEffect>> iterator = selectedEffects.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, CompareSelectedEffect> entry = iterator.next();
			CompareSelectedEffect ce = entry.getValue();
			if (!ce.isUserSelected()) {
				iterator.remove();
			} else {
				// resetto i bonus che poi ricalcolerò
				ce.getBonusesFirst().clear();
				ce.getBonusesSecond().clear();
			}
		}
	}
	
	private void addEffectFirst(Effect e) {
		if (e.getType() != null && e.getType().equalsIgnoreCase("Clickie")) {
			// TODO - Aggiungi il clikie alla lista
		} else {
			if (!selectedEffects.containsKey(e.getName())) {
				BaseEffect be = EquippedItems.getInstance().getEffect(e.getName());
				if (be == null) {
					log.debug(e.getName());
				}
				CompareSelectedEffect se = new CompareSelectedEffect();
				se.setName(e.getName());
				se.setUserSelected(false);
				se.setType(be.getType());
				selectedEffects.put(e.getName(), se);
			}
			CompareSelectedEffect se = selectedEffects.get(e.getName());
			se.setFirstPresent(true);;
			Map<String, Integer> mappaBonus = se.getBonusesFirst();
			Integer actualValue = mappaBonus.get(e.getType());
			if (actualValue == null || actualValue < e.getValue()) {
				mappaBonus.put(e.getType(), e.getValue());
			}
		}		
	}
	
	private void addEffectSecond(Effect e) {
		if (e.getType() != null && e.getType().equalsIgnoreCase("Clickie")) {
			// TODO - Aggiungi il clikie alla lista
		} else {
			if (!selectedEffects.containsKey(e.getName())) {
				BaseEffect be = EquippedItems.getInstance().getEffect(e.getName());
				if (be == null) {
					log.debug(e.getName());
				}
				CompareSelectedEffect se = new CompareSelectedEffect();
				se.setName(e.getName());
				se.setUserSelected(false);
				se.setType(be.getType());
				selectedEffects.put(e.getName(), se);
			}
			CompareSelectedEffect se = selectedEffects.get(e.getName());
			se.setSecondPresent(true);
			Map<String, Integer> mappaBonus = se.getBonusesSecond();
			Integer actualValue = mappaBonus.get(e.getType());
			if (actualValue == null || actualValue < e.getValue()) {
				mappaBonus.put(e.getType(), e.getValue());
			}
		}		
	}
	
	public void updateFirstSelectedSet() {
		Map<String, Integer> conteggioPezziSet = new HashMap<>();
		for (Item i : firstEquippedItems.values()) {
			if (i != null) {
				for (NamedSet ns : i.getSets()) {
					if (!firstSelectedSets.containsKey(ns.getName())) {
						SelectedSet ss = new SelectedSet(ns.getName(), ns.getPieces());
						ss.setActualNumberOfPieces(0);
						ss.setUserSelected(false);
						ss.getEffects().addAll(ns.getEffects());
						firstSelectedSets.put(ns.getName(), ss);
					}
					if (!conteggioPezziSet.containsKey(ns.getName())) {
						conteggioPezziSet.put(ns.getName(), 0);
					}
					Integer actual = conteggioPezziSet.get(ns.getName()) + 1;
					conteggioPezziSet.put(ns.getName(), actual);
				}
				for (AugmentSlot as : i.getAugments()) {
					Augment a = as.getAugment();
					if (a != null) for (NamedSet ns : a.getSets()) {
						if (!firstSelectedSets.containsKey(ns.getName())) {
							SelectedSet ss = new SelectedSet(ns.getName(), ns.getPieces());
							ss.setActualNumberOfPieces(0);
							ss.setUserSelected(false);
							ss.getEffects().addAll(ns.getEffects());
							firstSelectedSets.put(ns.getName(), ss);
						}
						if (!conteggioPezziSet.containsKey(ns.getName())) {
							conteggioPezziSet.put(ns.getName(), 0);
						}
						Integer actual = conteggioPezziSet.get(ns.getName()) + 1;
						conteggioPezziSet.put(ns.getName(), actual);
					}
				}
			}
		}
		// Elimino i set che non sono stati selezionati dall'utente e che hanno 0 pezzi
		for (String set : firstSelectedSets.keySet()) {
			Integer actual = conteggioPezziSet.get(set);
			SelectedSet ss = firstSelectedSets.get(set);
			if (actual == null && !ss.isUserSelected()) {
				firstSelectedSets.remove(set);
			} else {
				ss.setActualNumberOfPieces(actual != null ? actual : 0);
			}
		}
	}
	
	public void updateSecondSelectedSet() {
		Map<String, Integer> conteggioPezziSet = new HashMap<>();
		for (Item i : secondEquippedItems.values()) {
			if (i != null) {
				for (NamedSet ns : i.getSets()) {
					if (!secondSelectedSets.containsKey(ns.getName())) {
						SelectedSet ss = new SelectedSet(ns.getName(), ns.getPieces());
						ss.setActualNumberOfPieces(0);
						ss.setUserSelected(false);
						ss.getEffects().addAll(ns.getEffects());
						secondSelectedSets.put(ns.getName(), ss);
					}
					if (!conteggioPezziSet.containsKey(ns.getName())) {
						conteggioPezziSet.put(ns.getName(), 0);
					}
					Integer actual = conteggioPezziSet.get(ns.getName()) + 1;
					conteggioPezziSet.put(ns.getName(), actual);
				}
				for (AugmentSlot as : i.getAugments()) {
					Augment a = as.getAugment();
					if (a != null) for (NamedSet ns : a.getSets()) {
						if (!secondSelectedSets.containsKey(ns.getName())) {
							SelectedSet ss = new SelectedSet(ns.getName(), ns.getPieces());
							ss.setActualNumberOfPieces(0);
							ss.setUserSelected(false);
							ss.getEffects().addAll(ns.getEffects());
							secondSelectedSets.put(ns.getName(), ss);
						}
						if (!conteggioPezziSet.containsKey(ns.getName())) {
							conteggioPezziSet.put(ns.getName(), 0);
						}
						Integer actual = conteggioPezziSet.get(ns.getName()) + 1;
						conteggioPezziSet.put(ns.getName(), actual);
					}
				}
			}
		}
		// Elimino i set che non sono stati selezionati dall'utente e che hanno 0 pezzi
		for (String set : secondSelectedSets.keySet()) {
			Integer actual = conteggioPezziSet.get(set);
			SelectedSet ss = secondSelectedSets.get(set);
			if (actual == null && !ss.isUserSelected()) {
				secondSelectedSets.remove(set);
			} else {
				ss.setActualNumberOfPieces(actual != null ? actual : 0);
			}
		}
	}

}

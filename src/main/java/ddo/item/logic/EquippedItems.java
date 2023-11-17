package ddo.item.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ddo.item.entity.EItem;
import ddo.item.entity.EItemEffects;
import ddo.item.gui.effects.SelectedEffect;
import ddo.item.gui.set.SelectedSet;
import ddo.item.model.AugmentSlot;
import ddo.item.model.AugmentType;
import ddo.item.model.BodySlot;
import ddo.item.model.Effect;
import ddo.item.model.Item;
import ddo.item.repository.EItemEffectsRepository;
import ddo.item.repository.EItemRepository;

@Component
public class EquippedItems {
	
	private static EquippedItems singleton;
	
	@Autowired private EItemRepository repositoryItems;
	@Autowired private EItemEffectsRepository repositoryEffects;
	
	private final Set<String> effects = new HashSet<>();
	private final Map<String, SelectedEffect> selectedEffects = new HashMap<>();
	private final Map<String, Item> items;
	private final Map<BodySlot, Item> equippedItems;
	private final Set<AugmentSlot> augments;
	
	private EquippedItems() {
		equippedItems = new HashMap<>();
		for (BodySlot slot : BodySlot.values()) {
			equippedItems.put(slot, null);
		}
		items = new HashMap<>();
		augments = new HashSet<>();
		// Di questo se ne occupa spring.
		singleton = this;
	}
	
	public static EquippedItems getInstance() {
		return singleton;
	}
	
	@PostConstruct
	private void loadItems() {
		List<EItem> itemList = repositoryItems.findAll();
		for (EItem e : itemList) {
			Item i = trasforma(e);
			items.put(i.getName(), i);
		}
		List<EItemEffects> effectList = repositoryEffects.findAll();
		for (EItemEffects e : effectList) {
			Item i = items.get(e.getItemName());
			// Se è un augment lo aggiungo alla lista opportuna, se invece è un effetto alla lista degli effetti
			if (e.getEffect().equalsIgnoreCase("Augment Slot")) {
				AugmentSlot augment = new AugmentSlot(i.getName(), AugmentType.valueOf(e.getType()));
				i.addAugment(augment);
			} else {
				effects.add(e.getEffect());
				Effect f = trasforma(e);
				i.addEffect(f);
			}
		}
	}
	
	private Item trasforma(EItem e) {
		Item i = new Item(e.getSlot(), e.getName());
		return i;
	}
	
	private Effect trasforma(EItemEffects e) {
		Effect f = new Effect();
		f.setName(e.getEffect());
		f.setType(e.getType());
		f.setValue(e.getValue());
		return f;
	}
	
	public void equip(BodySlot slot, Item item) {
		// Se avevo già qualcosa su quello slot devo rimuovere gli augment
		Item old = equippedItems.get(slot);
		if (old != null) {
			for (AugmentSlot a :old.getAugments()) {
				augments.remove(a);
			}
		}
		equippedItems.put(slot, item);
		// Aggiorno i set
		SetManager.getInstance().updateSelectedSet();
		// Aggiorno i bonus
		updateSelectedEffects();
	}
	
	public void updateSelectedEffects() {
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
					for (Effect f : a.getEffects()) {
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
	
	public Map<BodySlot, Item> getEquippedItems() {
		return equippedItems;
	}
	
	public List<Item> getItems() {
		return new ArrayList<>(items.values());
	}
	
	public Set<String> getEffects() {
		return Collections.unmodifiableSet(effects);
	}
	
	public Map<String, SelectedEffect> getSelectedEffects() {
		return selectedEffects;
	}

	public Item getItem(String name) {
		return items.get(name);
	}

}

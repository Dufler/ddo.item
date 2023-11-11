package ddo.item.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ddo.item.entity.EItem;
import ddo.item.entity.EItemEffects;
import ddo.item.gui.effects.SelectedEffect;
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
	
	private EquippedItems() {
		equippedItems = new HashMap<>();
		for (BodySlot slot : BodySlot.values()) {
			equippedItems.put(slot, null);
		}
		items = new HashMap<>();
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
			effects.add(e.getEffect());
			Effect f = trasforma(e);
			Item i = items.get(e.getItemName());
			i.addEffect(f);
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
		equippedItems.put(slot, item);
		// Aggiorno i bonus
		for (Effect e : item.getEffects()) {
			if (!selectedEffects.containsKey(e.getName())) {
				SelectedEffect se = new SelectedEffect();
				se.setName(e.getName());
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

}

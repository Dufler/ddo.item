package ddo.item.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class Item {
	
	private final ItemType slot;
	private final String name;
	private int minimumLevel;
	private final Set<String> effects;
	
	public Item(ItemType slot, String name) {
		this.slot = slot;
		this.name = name;
		this.effects = new HashSet<>();
	}
	
	public void addEffect(String effect) {
		effects.add(effect);
	}

}

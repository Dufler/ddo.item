package ddo.item.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class Item {
	
	private final ItemType type;
	private final String name;
	private int minimumLevel;
	private final Set<Effect> effects;
	
	public Item(ItemType type, String name) {
		this.type = type;
		this.name = name;
		this.effects = new HashSet<>();
	}
	
	public void addEffect(Effect effect) {
		effects.add(effect);
	}

}

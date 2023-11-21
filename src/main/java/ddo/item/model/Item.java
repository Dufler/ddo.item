package ddo.item.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import lombok.Data;

@Data
public class Item {
	
	private final ItemType type;
	private final String name;
	private int minimumLevel;
	private final List<Effect> effects;
	private final Set<NamedSet> sets;
	private final Set<AugmentSlot> augments;
	
	public Item(ItemType type, String name) {
		this.type = type;
		this.name = name;
		this.effects = new LinkedList<>();
		this.sets = new HashSet<>();
		this.augments = new HashSet<>();
	}
	
	public void addEffect(Effect effect) {
		effects.add(effect);
	}
	
	public void addSet(NamedSet set) {
		sets.add(set);
	}
	
	public void addAugment(AugmentSlot augment) {
		augments.add(augment);
	}
	
	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

}

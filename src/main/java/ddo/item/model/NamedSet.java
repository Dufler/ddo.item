package ddo.item.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import lombok.Data;

@Data
public class NamedSet {
	
	private String name;
	private final Set<Item> items;
	private final Set<Effect> effects;
	private int pieces;
	
	public NamedSet() {
		items = new HashSet<>();
		effects = new HashSet<>();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NamedSet other = (NamedSet) obj;
		return Objects.equals(name, other.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	
	@Override
	public String toString() {
		return name;
	}

}

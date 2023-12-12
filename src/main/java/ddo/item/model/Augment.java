package ddo.item.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class Augment {
	
	private String name;
	private String type;
	private Integer minimumLevel;
	private final Set<Effect> effects;
	private final Set<NamedSet> sets;
	
	public Augment() {
		effects = new HashSet<>();
		sets = new HashSet<>();
	}
	
	@Override
	public String toString() {
		return name;
	}

}

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
	
	public Augment() {
		effects = new HashSet<>();
	}
	
	@Override
	public String toString() {
		return name;
	}

}

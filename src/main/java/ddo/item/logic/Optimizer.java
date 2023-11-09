package ddo.item.logic;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import ddo.item.entity.EItem;

@Component
public class Optimizer {
	
	private Set<EItem> equippedItems;
	private Set<String> desideredEffects;
	
	public Optimizer() {
		equippedItems = new HashSet<>();
		desideredEffects = new HashSet<>();
	}
	
	public Set<EItem> getEquippedItems() {
		return equippedItems;
	}
	
	public Set<String> getDesideredEffects() {
		return desideredEffects;
	}

}

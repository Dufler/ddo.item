package ddo.item.gui.effects;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

import ddo.item.model.EffectShowType;
import lombok.Data;

@Data
public class SelectedEffect {
	
	private static final Set<String> simpleTypes = new HashSet<>(Arrays.asList("Enhancement", "Insightful", "Quality"));
	private static final Set<String> allTypes = new HashSet<>(Arrays.asList("Enhancement", "Insightful", "Quality", "Sacred", "Profane", "Exceptional"));
	
	private String name;
	private EffectShowType show;
	private final Map<String, Integer> bonuses = new HashMap<>();
	
	private boolean userSelected;
	private Integer priority;
	
	public int getTotalBonus() {
		int total = 0;
		for (Integer i : bonuses.values()) {
			total += i != null ? i : 0;
		}
		return total;
	}
	
	public int getBonusByType(String type) {
		return bonuses.containsKey(type) ? bonuses.get(type) : 0;
	}
	
	public int getOtherBonus() {
		int total = 0;
		for (Entry<String, Integer> e : bonuses.entrySet()) {
			if (!simpleTypes.contains(e.getKey()))
				total += e.getValue() != null ? e.getValue() : 0;
		}
		return total;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SelectedEffect other = (SelectedEffect) obj;
		return Objects.equals(name, other.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	public Set<String> getBonusesNotPresent() {
		HashSet<String> types = new HashSet<>(allTypes);
		for (Entry<String, Integer> e : bonuses.entrySet()) {
			if (e.getValue() != null && e.getValue() > 0)
				types.remove(e.getKey());
		}
		return types;
	}
	
}

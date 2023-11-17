package ddo.item.gui.effects;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import lombok.Data;

@Data
public class SelectedEffect {
	
	private String name;
	private final Map<String, Integer> bonuses = new HashMap<>();
	
	private boolean userSelected;
	
	public int getTotalBonus() {
		int total = 0;
		for (Integer i : bonuses.values()) {
			total += i != null ? i : 0;
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
	
}

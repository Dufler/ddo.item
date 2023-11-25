package ddo.item.gui.effects;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class CompareSelectedEffect {
	
	private String name;
	private boolean userSelected;
	private final Map<String, Integer> bonusesFirst = new HashMap<>();
	private final Map<String, Integer> bonusesSecond = new HashMap<>();
	
	public int getTotalBonusFirst() {
		int total = 0;
		for (Integer i : bonusesFirst.values()) {
			total += i != null ? i : 0;
		}
		return total;
	}
	
	public int getTotalBonusSecond() {
		int total = 0;
		for (Integer i : bonusesSecond.values()) {
			total += i != null ? i : 0;
		}
		return total;
	}

}

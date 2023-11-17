package ddo.item.gui.set;

import java.util.HashSet;
import java.util.Set;

import ddo.item.model.Effect;
import lombok.Data;

@Data
public class SelectedSet {
	
	private final String name;
	private final Set<Effect> effects;
	private final int maxNumberOfPieces;
	private int actualNumberOfPieces;
	
	
	private boolean userSelected;
	
	public SelectedSet(String name, int maxNumberOfPieces) {
		this.name = name;
		this.maxNumberOfPieces = maxNumberOfPieces;
		this.effects = new HashSet<>();
	}

}

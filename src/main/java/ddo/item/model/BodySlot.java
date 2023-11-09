package ddo.item.model;

/**
 * Definisce i possibili slot su cui indossare oggetti
 */
public enum BodySlot {
	
	HEAD("Head"),
	EYES("Eyes"),
	NECK("Neck"),
	BACK("Back"),
	FEET("Feet"),
	WAIST("Waist"),
	WRIST("Wrists"),
	BODY("Body"),
	HANDS("Hands"),
	MAIN_HAND("Main hand"),
	OFF_HAND("Off hand"),
	FINGER_1("First Finger"),
	FINGER_2("Second Finger"),
	TRINKET("Trinket"),
	QUIVER("Quiver");
	
	private final String description;
	
	private BodySlot(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return description;
	}

}

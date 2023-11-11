package ddo.item.model;

/**
 * Definisce i possibili tipi di oggetto in ddo
 * @author Damiano
 *
 */
public enum ItemType {

	BELT(BodySlot.WAIST),
	BOOTS(BodySlot.FEET),
	BRACERS(BodySlot.WRIST),
	CLOAK(BodySlot.BACK),
	GLOVES(BodySlot.HANDS),
	GOGGLES(BodySlot.EYES),
	HELM(BodySlot.HEAD),
	NECKLACE(BodySlot.NECK),
	RING(BodySlot.FINGER_1), // anche finger 2
	TRINKET(BodySlot.TRINKET),
	//QUIVER(BodySlot.QUIVER), //Wiki page is in a different format
	// Armors
	ARMOR_CLOTH(BodySlot.BODY),
	ARMOR_LIGHT(BodySlot.BODY),
	ARMOR_MEDIUM(BodySlot.BODY),
	ARMOR_HEAVY(BodySlot.BODY),
	//ARMOR_DOCENT(BodySlot.BODY), //Wiki page is in a different format
	// Weapons
	//DAGGER(BodySlot.MAIN_HAND), //anche off hand
	//KUKRI(BodySlot.MAIN_HAND),
	// Shields
	ORB(BodySlot.OFF_HAND);
	//BUCKLER(BodySlot.OFF_HAND);
	
	private final BodySlot slot;
	
	private ItemType(BodySlot slot) {
		this.slot = slot;
	}
	
	public BodySlot getSlot() {
		return slot;
	}
	
}

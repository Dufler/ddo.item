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
	RING(BodySlot.FINGER_1, BodySlot.FINGER_2),
	TRINKET(BodySlot.TRINKET),
	QUIVER(BodySlot.QUIVER), //Wiki page is in a different format
	// Armors
	ARMOR_CLOTH(BodySlot.BODY),
	ARMOR_LIGHT(BodySlot.BODY),
	ARMOR_MEDIUM(BodySlot.BODY),
	ARMOR_HEAVY(BodySlot.BODY),
	ARMOR_DOCENT(BodySlot.BODY), //Wiki page is in a different format
	// Simple Weapons
	CLUB(BodySlot.MAIN_HAND, BodySlot.OFF_HAND),
	QUARTERSTAFF(true, BodySlot.MAIN_HAND),
	DAGGER(BodySlot.MAIN_HAND, BodySlot.OFF_HAND),
	SICKLE(BodySlot.MAIN_HAND, BodySlot.OFF_HAND),
	LIGHTMACE(BodySlot.MAIN_HAND, BodySlot.OFF_HAND),
	HEAVYMACE(BodySlot.MAIN_HAND, BodySlot.OFF_HAND),
	MORNINGSTAR(BodySlot.MAIN_HAND, BodySlot.OFF_HAND),
	LIGHTCROSSBOW(true, BodySlot.MAIN_HAND),
	HEAVYCROSSBOW(true, BodySlot.MAIN_HAND),
	// Martial Weapon
	HANDAXE(BodySlot.MAIN_HAND, BodySlot.OFF_HAND),
	BATTLEAXE(BodySlot.MAIN_HAND, BodySlot.OFF_HAND),
	GREATAXE(true, BodySlot.MAIN_HAND),
	KUKRI(BodySlot.MAIN_HAND, BodySlot.OFF_HAND),
	LONGSWORD(BodySlot.MAIN_HAND, BodySlot.OFF_HAND),
	GREATSWORD(true, BodySlot.MAIN_HAND),
	SCIMITAR(BodySlot.MAIN_HAND, BodySlot.OFF_HAND),
	FALCHION(true, BodySlot.MAIN_HAND),
	LONGBOW(true, BodySlot.MAIN_HAND),
	SHORTSWORD(BodySlot.MAIN_HAND, BodySlot.OFF_HAND),
	RAPIER(BodySlot.MAIN_HAND, BodySlot.OFF_HAND),
	LIGHTPICK(BodySlot.MAIN_HAND, BodySlot.OFF_HAND),
	HEAVYPICK(BodySlot.MAIN_HAND, BodySlot.OFF_HAND),
	LIGHTHAMMER(BodySlot.MAIN_HAND, BodySlot.OFF_HAND),
	WARHAMMER(BodySlot.MAIN_HAND, BodySlot.OFF_HAND),
	MAUL(true, BodySlot.MAIN_HAND),
	GREATCLUB(true, BodySlot.MAIN_HAND),
	SHORTBOW(true, BodySlot.MAIN_HAND),
	// Exotic Weapons
	BASTARDSWORD(BodySlot.MAIN_HAND, BodySlot.OFF_HAND),
	DWARVENWARAXE(BodySlot.MAIN_HAND, BodySlot.OFF_HAND),
	KAMA(BodySlot.MAIN_HAND, BodySlot.OFF_HAND),
	KHOPESH(BodySlot.MAIN_HAND, BodySlot.OFF_HAND),
	HANDWRAPS(true, BodySlot.MAIN_HAND),
	RUNEARM(BodySlot.OFF_HAND),
	GREATCROSSBOW(true, BodySlot.MAIN_HAND),
	REPEATINGLIGHTCROSSBOW(true, BodySlot.MAIN_HAND),
	REPEATINGHEAVYCROSSBOW(true, BodySlot.MAIN_HAND),
	// Throwing Weapons
	THROWINGAXE(BodySlot.MAIN_HAND),
	THROWINGDAGGER(BodySlot.MAIN_HAND),
	THROWINGHAMMER(BodySlot.MAIN_HAND),
	DART(BodySlot.MAIN_HAND),
	SHURIKEN(BodySlot.MAIN_HAND),
	// Shields
	ORB(BodySlot.OFF_HAND),
	BUCKLER(BodySlot.OFF_HAND),
	SMALLSHIELD(BodySlot.OFF_HAND),
	LARGESHIELD(BodySlot.OFF_HAND),
	TOWERSHIELD(BodySlot.OFF_HAND);
	
	private final BodySlot[] slots;
	private final boolean twoHanded;
	
	private ItemType(BodySlot ...slot) {
		this(false, slot);
	}
	
	private ItemType(boolean twoHanded, BodySlot ...slot) {
		this.slots = slot;
		this.twoHanded = twoHanded;
	}
	
	public BodySlot[] getSlot() {
		return slots;
	}

	public boolean isTwoHanded() {
		return twoHanded;
	}
	
}

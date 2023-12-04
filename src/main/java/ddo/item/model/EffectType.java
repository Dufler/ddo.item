package ddo.item.model;

public enum EffectType {
	
	clickie(EffectShowType.none),
	ability(EffectShowType.numeric),
	skill(EffectShowType.numeric),
	movement(EffectShowType.numeric),
	attribute(EffectShowType.numeric), // Hit Point, Spell points
	general_combat(EffectShowType.numeric),
	tactical(EffectShowType.numeric),
	dr_bypass(EffectShowType.not_numeric),
	melee_combat(EffectShowType.numeric),
	ranged_combat(EffectShowType.numeric),
	weapon_proc(EffectShowType.none),
	debuff(EffectShowType.none),
	bane(EffectShowType.none),
	spellcasting(EffectShowType.numeric),
	guard(EffectShowType.numeric),
	defense(EffectShowType.numeric),
	elemental_defense(EffectShowType.numeric),
	saves(EffectShowType.numeric),
	immunity(EffectShowType.not_numeric),
	charges(EffectShowType.numeric),
	general(EffectShowType.not_numeric), // well know effects like Freedom of Movement (no numeric values)
	special(EffectShowType.not_numeric), // special effects like better offhanded (no numeric values)
	material(EffectShowType.none),
	feat(EffectShowType.not_numeric),
	upgrade(EffectShowType.none),
	uncategorized(EffectShowType.none);
	
	private final EffectShowType show;
	
	private EffectType(EffectShowType show) {
		this.show = show;
	}

	public EffectShowType getShow() {
		return show;
	}

}

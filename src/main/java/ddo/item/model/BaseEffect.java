package ddo.item.model;

import lombok.Data;

@Data
public class BaseEffect {
	
	private String effect;
	private String description;
	private EffectType type;

}

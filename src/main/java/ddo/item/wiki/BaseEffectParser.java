package ddo.item.wiki;

import org.springframework.stereotype.Component;

import ddo.item.model.Effect;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BaseEffectParser {
	
	public Effect parseEffect(String effectDescription) {
		// Parso il tipo di bonus, se presente
		String bonusType = parseBonusType(effectDescription);
		if (bonusType != null) {
			effectDescription = effectDescription.replace(bonusType, "");
		}
		Integer bonusValue = null;
		int index = effectDescription.indexOf('+');
		if (index != -1) {
			String value = effectDescription.substring(index + 1);
			try { bonusValue = Integer.parseInt(value); } catch(Exception e) { log.error(e.getMessage()); }
				effectDescription = effectDescription.substring(0, index);
		}
		effectDescription = effectDescription.trim();
		if (effectDescription.length() > 100) {
			effectDescription = effectDescription.substring(0, 100);
		}
		Effect effect = new Effect();
		effect.setName(effectDescription);
		effect.setType(bonusType);
		effect.setValue(bonusValue);
		return effect;
	}
	
	private String parseBonusType(String effectDescription) {
		String type = null;
		if (effectDescription.contains("Insightful")) {
			type = "Insightful";
		}
		if (effectDescription.contains("Quality")) {
			type = "Quality";
		}
		if (effectDescription.contains("Profane")) {
			type = "Profane";
		}
		if (effectDescription.contains("Sacred")) {
			type = "Sacred";
		}
		return type;
	}

}

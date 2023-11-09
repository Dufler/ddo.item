package ddo.item.logic;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ddo.item.entity.EItemEffects;
import ddo.item.repository.EItemEffectsRepository;

@Component
public class Effects {
	
	@Autowired private EItemEffectsRepository repository;
	
	private final Set<String> effects = new HashSet<>();
	private final Set<String> selectedEffects = new HashSet<>();
	
	@PostConstruct
	private void loadEffects() {
		List<EItemEffects> effectsList = repository.findAll();
		for (EItemEffects effect : effectsList) {
			effects.add(effect.getEffect());
		}
	}
	
	public Set<String> getEffects() {
		return Collections.unmodifiableSet(effects);
	}
	
	public Set<String> getSelectedEffects() {
		return selectedEffects;
	}

}

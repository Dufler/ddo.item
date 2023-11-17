package ddo.item.logic;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ddo.item.entity.EAugment;
import ddo.item.entity.EAugmentEffect;
import ddo.item.model.Augment;
import ddo.item.model.Effect;
import ddo.item.repository.EAugmentEffectRepository;
import ddo.item.repository.EAugmentRepository;

@Component
public class AugmentManager {

	private static AugmentManager instance;
	
	@Autowired private EAugmentRepository augmentRepository;
	@Autowired private EAugmentEffectRepository effectRepository;
	
	private final Map<String, List<Augment>> mapForType;	
	private final Map<String, Augment> augments;	
	
	private AugmentManager() {
		mapForType = new HashMap<>();
		augments = new HashMap<>();
		instance = this;
	}
	
	public static AugmentManager getInstance() {
		return instance;
	}
	
	@PostConstruct
	private void loadData() {
		List<EAugment> augmentList = augmentRepository.findAll();
		for (EAugment ea : augmentList) {
			Augment a = new Augment();
			a.setName(ea.getName());
			a.setType(ea.getType());
			a.setMinimumLevel(ea.getMinimumLevel());
			augments.put(ea.getName(), a);
			if (!mapForType.containsKey(ea.getType())) {
				mapForType.put(ea.getType(), new LinkedList<>());
			}
			List<Augment> list = mapForType.get(ea.getType());
			list.add(a);
		}
		List<EAugmentEffect> effectList = effectRepository.findAll();
		for (EAugmentEffect ae : effectList) {
			Effect e = new Effect();
			e.setName(ae.getEffect());
			e.setType(ae.getType());
			e.setValue(ae.getValue());
			Augment a = augments.get(ae.getAugment());
			a.getEffects().add(e);
		}
	}
	
	public Augment getByName(String name) {
		return augments.get(name);
	}
	
	public Collection<Augment> getAll() {
		return augments.values();
	}
	
	public List<Augment> getAugmentForType(String type) {
		return mapForType.get(type);
	}
	
}

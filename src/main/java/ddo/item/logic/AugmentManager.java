package ddo.item.logic;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ddo.item.entity.EAugment;
import ddo.item.entity.EAugmentEffect;
import ddo.item.entity.EAugmentTypeEquivalent;
import ddo.item.model.Augment;
import ddo.item.model.Effect;
import ddo.item.repository.EAugmentEffectRepository;
import ddo.item.repository.EAugmentRepository;
import ddo.item.repository.EAugmentTypeEquivalentRepository;

@Component
public class AugmentManager {

	private static AugmentManager instance;
	
	@Autowired private EAugmentRepository augmentRepository;
	@Autowired private EAugmentEffectRepository effectRepository;
	@Autowired private EAugmentTypeEquivalentRepository equivalentRepository;
	
	private final Map<String, List<Augment>> mapForType;	
	private final Map<String, Augment> augments;
	private final Map<String, Set<String>> equivalent;
	
	private AugmentManager() {
		mapForType = new HashMap<>();
		augments = new HashMap<>();
		equivalent = new HashMap<>();
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
		List<EAugmentTypeEquivalent> equivalentList = equivalentRepository.findAll();
		for (EAugmentTypeEquivalent e : equivalentList) {
			if (!equivalent.containsKey(e.getBase())) {
				HashSet<String> colors = new HashSet<>();
				colors.add(e.getBase());
				equivalent.put(e.getBase(), colors);
			}
			equivalent.get(e.getBase()).add(e.getUsable());
		}
	}
	
	public Augment getByName(String name) {
		return augments.get(name);
	}
	
	public Collection<Augment> getAll() {
		return augments.values();
	}
	
	public List<Augment> getAugmentForType(String type) {
		return mapForType.containsKey(type) ? mapForType.get(type) : Collections.emptyList();
	}
	
	public List<Augment> getAugmentSlottableInType(String type) {
		List<Augment> augments = new LinkedList<>();
		// recupero tutti i colori disponibili per quel type
		Set<String> types = equivalent.get(type);
		if (types != null) {
			for (String t : types) {
				augments.addAll(getAugmentForType(t));
			}
		} else {
			augments.addAll(getAugmentForType(type));
		}
		return augments;
	}
	
}

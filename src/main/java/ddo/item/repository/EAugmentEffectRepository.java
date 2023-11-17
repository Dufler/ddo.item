package ddo.item.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ddo.item.entity.EAugmentEffect;

@Repository
public interface EAugmentEffectRepository extends JpaRepository<EAugmentEffect, Integer> {
	
	public List<EAugmentEffect> findByAugment(String augment);

}

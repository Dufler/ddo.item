package ddo.item.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ddo.item.entity.EEffect;
import ddo.item.model.EffectType;

@Repository
public interface EEffectRepository extends JpaRepository<EEffect, String> {
	
	public List<EEffect> findByType(EffectType type);

}

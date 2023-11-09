package ddo.item.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ddo.item.entity.EItemEffects;

@Repository
public interface EItemEffectsRepository extends JpaRepository<EItemEffects, Integer> {
	
	public List<EItemEffects> findByItemId(Integer itemId);

}

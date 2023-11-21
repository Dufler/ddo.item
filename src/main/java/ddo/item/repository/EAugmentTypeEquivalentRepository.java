package ddo.item.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ddo.item.entity.EAugmentTypeEquivalent;
import ddo.item.entity.EAugmentTypeEquivalentPK;

@Repository
public interface EAugmentTypeEquivalentRepository extends JpaRepository<EAugmentTypeEquivalent, EAugmentTypeEquivalentPK> {

	public List<EAugmentTypeEquivalent> findByBase(String base);
	
}

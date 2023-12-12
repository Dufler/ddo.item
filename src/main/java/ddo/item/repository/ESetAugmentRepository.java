package ddo.item.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ddo.item.entity.ESetAugment;
import ddo.item.entity.ESetAugmentPK;

@Repository
public interface ESetAugmentRepository extends JpaRepository<ESetAugment, ESetAugmentPK> {

	public List<ESetAugment> findBySet(String set);
	
	public List<ESetAugment> findByAugment(String augment);

}

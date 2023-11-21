package ddo.item.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ddo.item.entity.EGearSetupAugment;
import ddo.item.entity.EGearSetupAugmentPK;

@Repository
public interface EGearSetupAugmentRepository extends JpaRepository<EGearSetupAugment, EGearSetupAugmentPK> {
	
	public List<EGearSetupAugment> findByIdSetup(Integer id);
	
	public List<EGearSetupAugment> findByIdSetupAndItem(Integer id, String item);

}

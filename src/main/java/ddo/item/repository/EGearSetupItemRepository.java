package ddo.item.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ddo.item.entity.EGearSetupItem;
import ddo.item.entity.EGearSetupItemPK;

@Repository
public interface EGearSetupItemRepository extends JpaRepository<EGearSetupItem, EGearSetupItemPK> {

	public List<EGearSetupItem> findByIdSetup(Integer id);
	
}

package ddo.item.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ddo.item.entity.ESetItem;
import ddo.item.entity.ESetItemPK;

@Repository
public interface ESetItemRepository extends JpaRepository<ESetItem, ESetItemPK> {

	public List<ESetItem> findBySet(String set);
	
	public List<ESetItem> findByItem(String item);
	
}

package ddo.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ddo.item.entity.EItem;

@Repository
public interface EItemRepository extends JpaRepository<EItem, String> {
	
	public EItem findByName(String name);

}

package ddo.item.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ddo.item.entity.EItem;

@Repository
public interface EItemRepository extends JpaRepository<EItem, Integer> {
	
	public List<EItem> findByName(String name);

}

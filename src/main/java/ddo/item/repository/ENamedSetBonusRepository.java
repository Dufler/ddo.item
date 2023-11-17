package ddo.item.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ddo.item.entity.ENamedSetBonus;

@Repository
public interface ENamedSetBonusRepository extends JpaRepository<ENamedSetBonus, Integer> {
	
	public List<ENamedSetBonus> findBySet(String setName);

}

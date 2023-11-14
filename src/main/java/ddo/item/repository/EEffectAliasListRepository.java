package ddo.item.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ddo.item.entity.EEffectAliasList;

@Repository
public interface EEffectAliasListRepository extends JpaRepository<EEffectAliasList, Integer> {
	
	public List<EEffectAliasList> findByAlias(String alias);

}

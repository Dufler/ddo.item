package ddo.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ddo.item.entity.EEffectAlias;

@Repository
public interface EEffectAliasRepository extends JpaRepository<EEffectAlias, String> {

}

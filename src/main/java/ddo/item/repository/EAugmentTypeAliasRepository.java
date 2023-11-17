package ddo.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ddo.item.entity.EAugmentTypeAlias;

@Repository
public interface EAugmentTypeAliasRepository extends JpaRepository<EAugmentTypeAlias, String> {

}

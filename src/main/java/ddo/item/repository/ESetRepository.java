package ddo.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ddo.item.entity.ESet;

@Repository
public interface ESetRepository extends JpaRepository<ESet, String> {

}

package ddo.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ddo.item.entity.EAugment;

@Repository
public interface EAugmentRepository extends JpaRepository<EAugment, String> {

}

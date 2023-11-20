package ddo.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ddo.item.entity.EGearSetup;

@Repository
public interface EGearSetupRepository extends JpaRepository<EGearSetup, Integer> {

}

package ddo.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ddo.item.entity.EEffect;

@Repository
public interface EEffectRepository extends JpaRepository<EEffect, String> {

}

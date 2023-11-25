package ddo.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ddo.item.entity.ESkippableItem;

@Repository
public interface ESkippableItemRepository extends JpaRepository<ESkippableItem, String> {

}

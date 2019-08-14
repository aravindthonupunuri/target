package com.dojoitem.dojoitem.repository;

import com.dojoitem.dojoitem.item.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {
    ItemEntity findByName(String name);
}

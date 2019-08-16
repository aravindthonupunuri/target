package com.dojoitem.dojoitem.repository;

import com.dojoitem.dojoitem.item.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {
    ItemEntity findByName(String name);

    List<ItemEntity> findByCategory(String category);
<<<<<<< HEAD

=======
>>>>>>> 20d52ded23b0ba29c834c88c93ede2cbcea161b4
}

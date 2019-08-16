package com.dojoitem.dojoitem.dao;

import com.dojoitem.dojoitem.item.ItemEntity;
import com.dojoitem.dojoitem.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Configuration
public class ItemDao {
    @Autowired
    ItemRepository itemRepository;

    public ItemDao(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemDao() {
    }
    @Transactional
    public ItemEntity createItem(ItemEntity itemEntity){
        itemRepository.save(itemEntity);
        return itemEntity;
    }
    public ItemEntity getItemByName(String name){return itemRepository.findByName(name);}
    public List<ItemEntity> getAllItem()
    {
        List<ItemEntity> itemEntityList = itemRepository.findAll();
        return itemEntityList;
    }
    public List<ItemEntity> getAllItemByCategory(String category) {
        List<ItemEntity> itemEntityList = itemRepository.findByCategory(category);
        return itemEntityList;
    }
    public ItemEntity getItem(int itemKey){
        return itemRepository.getOne(itemKey);
    }

    public ItemEntity addItem (ItemEntity itemEntity){
        itemRepository.save(itemEntity);
        return itemEntity;
    }
    public boolean updateItem (ItemEntity itemEntity){

        if(itemRepository.existsById(itemEntity.getItemId())){
            itemRepository.save(itemEntity);
            return true;
        }
        else{
            return false;
        }
    }
    public void deleteItem(int item_Id){
        itemRepository.deleteById(item_Id);


    }


    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


}

package com.dojoitem.dojoitem.dao;

import com.dojoitem.dojoitem.item.ItemEntity;
import com.dojoitem.dojoitem.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
//import sun.tools.tree.ContinueStatement;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

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

    ItemEntity exception = new ItemEntity(-1,"none","none","none","none",0);

    public ItemEntity getItem(int itemKey) {

        try {
           if(itemKey == 123 || itemKey == 124 || itemKey == 125 || itemKey == 126)
                  return itemRepository.getOne(itemKey);
        }catch (Exception e){
           return exception;
        }
return exception;
    }

    public ItemEntity addItem (ItemEntity itemEntity){
        itemRepository.save(itemEntity);
        return itemEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDao itemDao = (ItemDao) o;
        return itemRepository.equals(itemDao.itemRepository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemRepository);
    }

    public int updateItem (ItemEntity itemEntity){

//        if(itemRepository.existsById(itemEntity.getItem_id())){
//            itemRepository.save(itemEntity);
//            return true;
//        }
//        else{
//            return false;
//        }
//    }
//    public void deleteItem(int item_Id){
//        itemRepository.deleteById(item_Id);

        if(itemRepository.existsById(itemEntity.getItem_id())){
            itemRepository.save(itemEntity);
            return 1;
        }
        else{
            return 0;
        }
    }
    public void deleteItem(int item_Id){
        itemRepository.deleteById(item_Id);
    }


    public List<ItemEntity> getByCategory(String category)
    {
        List<ItemEntity> itemEntityList = itemRepository.findByCategory(category);
        return itemEntityList;
    }


    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


}

package com.dojoitem.dojoitem.service;

import com.dojoitem.dojoitem.dao.ItemDao;
import com.dojoitem.dojoitem.item.Item;
import com.dojoitem.dojoitem.item.ItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//import com.dojoitem.dojoitem.item.*;
@Service
public class ItemService {
    @Autowired
    ItemDao itemDao;
   public Item getItemByName(String name){
       ItemEntity itemEntity = itemDao.getItemByName(name);
       return mapTo(itemEntity);
   }

    public List<ItemEntity> getAllItem()
    {
//    List<ItemEntity> itemEntityList= itemRepository.findAll();
        List<ItemEntity> itemEntityList = itemDao.getAllItem();
        // return (List<Item>)(List<?>)itemEntityList;
        return itemEntityList;
    }
    public List<ItemEntity> getAllItemByCategory(String category) {
       List<ItemEntity> itemEntityList = itemDao.getAllItemByCategory(category);
        return itemEntityList;
    }

    public ItemService(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public ItemService() {
    }
    public Item createItem(Item item){
        ItemEntity itemEntity = itemDao.createItem(mapTo(item));
        return mapTo(itemEntity);
    }
    public Item mapTo(ItemEntity itemEntity){
        return new Item(itemEntity.getItem_id(),itemEntity.getName(),itemEntity.getDescription(),itemEntity.getCategory(),itemEntity.getImage_url(),itemEntity.isSellable());
    }

    public ItemEntity mapTo(Item item){
        return new ItemEntity(item.getItem_id(),item.getName(),item.getDescription(),item.getCategory(),item.getImage_url(),item.isSellable());
    }
    public Item getItem(int item_id){
        ItemEntity itemEntity = itemDao.getItem(item_id);
        return mapTo(itemEntity);

    }
    public Item addItem(Item item)
    {
        ItemEntity itemEntity=itemDao.addItem(mapTo(item));
        return mapTo(itemEntity);
    }
    public int updateItem(Item item)
    {
        return itemDao.updateItem(mapTo(item));
    }
    public void deleteItem(int item_id){
       itemDao.deleteItem(item_id);


    }


    public ItemDao getItemDao() {
        return itemDao;
    }

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }


}

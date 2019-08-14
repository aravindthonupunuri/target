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
    public List<ItemEntity> getByCategory(String category){
        List<ItemEntity> itemEntityList = itemDao.getByCategory(category);
        return  itemEntityList;
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
    private Item mapTo(ItemEntity itemEntity){
        return new Item(itemEntity.getItemId(),itemEntity.getName(),itemEntity.getDescription(),itemEntity.getCategory(),itemEntity.getImage_url(),itemEntity.isSellable());
    }

    private ItemEntity mapTo(Item item){
        return new ItemEntity(item.getItemId(),item.getName(),item.getDescription(),item.getCategory(),item.getImage_url(),item.isSellable());
    }
    public Item getItem(int item_Id){
        ItemEntity itemEntity = itemDao.getItem(item_Id);
        return mapTo(itemEntity);
    }
    public Item addItem(Item item)
    {
        ItemEntity itemEntity=itemDao.addItem(mapTo(item));
        return mapTo(itemEntity);
    }
    public boolean updateItem(Item item)
    {
        return itemDao.updateItem(mapTo(item));
    }
    public void deleteItem(int item_Id){
       itemDao.deleteItem(item_Id);

    }
public List<ItemEntity> getAllItem()
{
//    List<ItemEntity> itemEntityList= itemRepository.findAll();
    List<ItemEntity> itemEntityList = itemDao.getAllItem();
   // return (List<Item>)(List<?>)itemEntityList;
    return itemEntityList;
}

    public ItemDao getItemDao() {
        return itemDao;
    }

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

}

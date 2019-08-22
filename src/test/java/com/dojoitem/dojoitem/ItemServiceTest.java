package com.dojoitem.dojoitem;

import com.dojoitem.dojoitem.dao.ItemDao;
import com.dojoitem.dojoitem.item.Item;
import com.dojoitem.dojoitem.item.ItemEntity;
import com.dojoitem.dojoitem.service.ItemService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
@Transactional
@RunWith(MockitoJUnitRunner.class)

public class ItemServiceTest {
    @InjectMocks
    ItemService itemService;

    @Mock
    ItemDao itemDao;
    List<ItemEntity> itemEntityList = Arrays.asList(new ItemEntity(35, "nike", "sneakers", "shoes", "htt", 1),
            new ItemEntity(35, "nike", "sneakers", "shoes", "htt", 1));

    @Test
    public void addItemTest() {
        Item item = new Item();
        item.setItem_id(35);
        item.setName("Nike");
        item.setDescription("Sneakers");
        item.setCategory("shoes");
        item.setImage_url("http://hsdg");
        item.setSellable(1);
        ItemEntity itemEntity = itemService.mapTo(item);
        when(itemDao.addItem(itemEntity)).thenReturn(itemEntity);
        Item addedItem = itemService.addItem(item);
        Assert.assertEquals(item, addedItem);
    }

    @Test
    public void getItemTest() {
        Item item = new Item();
        item.setItem_id(35);
        item.setName("Nike");
        item.setDescription("Sneakers");
        item.setCategory("shoes");
        item.setImage_url("http://hsdg");
        item.setSellable(1);
        ItemEntity itemEntity = itemService.mapTo(item);
        when(itemDao.getItem(35)).thenReturn(itemEntity);
        Item expectedItem = itemService.mapTo(itemEntity);
        Item addedItem = itemService.getItem(35);
        Assert.assertEquals(expectedItem.hashCode(), addedItem.hashCode());
        Assert.assertTrue(expectedItem.equals(addedItem));
    }

    @Test
    public void deleteItemTest()
    {
        itemService.deleteItem(35);
        verify(itemDao,times(1)).deleteItem(35);
    }

    @Test
    public void getAllItemTest() {
        when(itemDao.getAllItem()).thenReturn(itemEntityList);
        Assert.assertEquals(itemEntityList, itemService.getAllItem());
    }


    @Test
    public void getItemByNameTest() {
        Item item = new Item();
        item.setItem_id(35);
        item.setName("Nike");
        item.setDescription("Sneakers");
        item.setCategory("shoes");
        item.setImage_url("http://hsdg");
        item.setSellable(1);
        ItemEntity itemEntity = itemService.mapTo(item);
        when(itemDao.getItemByName("Nike")).thenReturn(itemEntity);
        Item expectedItem = itemService.mapTo(itemEntity);
        Item addedItem = itemService.getItemByName("Nike");
        Assert.assertEquals(expectedItem.hashCode(), addedItem.hashCode());
        Assert.assertTrue(expectedItem.equals(addedItem));
    }

    @Test
    public void getItemByCategoryTest()  {
        when(itemDao.getAllItemByCategory("Sneakers")).thenReturn(itemEntityList);
        Assert.assertEquals(itemEntityList, itemService.getAllItemByCategory("Sneakers"));
    }


}
package com.dojoitem.dojoitem;

import com.dojoitem.dojoitem.dao.ItemDao;
import com.dojoitem.dojoitem.item.Item;
import com.dojoitem.dojoitem.item.ItemEntity;
import com.dojoitem.dojoitem.repository.ItemRepository;
import com.dojoitem.dojoitem.service.ItemService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;

import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@Transactional
@RunWith(MockitoJUnitRunner.class)

public class ItemServiceTest {
    @InjectMocks
    ItemService itemService;

    @Mock
    //ItemRepository itemRepository;
            ItemDao itemDao;

    //    Item shirtItem;
    // @Mock
    //private ItemRepository itemRepository;
//    private List<Item> item;
//    private Item shirtItem;
//    @Before
//    public void setup(){
//        shirtItem = new Item(12346,"shirt","cloth","wear","htrto",true);
//       //item1 = new Item(1234566890,"ghhfj","DFGHJB","FGHJHGF","HGFFGH",true);
//    }
    @Test
    public void addItemTest() {
        Item item = new Item();
        item.setItemId(35);
        item.setName("Nike");
        item.setDescription("Sneakers");
        item.setCategory("shoes");
        item.setImage_url("http://hsdg");
        item.setSellable(true);
        ItemEntity itemEntity = itemService.mapTo(item);
        when(itemDao.addItem(itemEntity)).thenReturn(itemEntity);
        Item addedItem = itemService.addItem(item);
        Assert.assertEquals(item, addedItem);
    }

    @Test
    public void getItemTest() {
        Item item = new Item();
        item.setItemId(35);
        item.setName("Nike");
        item.setDescription("Sneakers");
        item.setCategory("shoes");
        item.setImage_url("http://hsdg");
        item.setSellable(true);
        ItemEntity itemEntity = itemService.mapTo(item);
        when(itemDao.getItem(35)).thenReturn(itemEntity);
        Item expectedItem = itemService.mapTo(itemEntity);
        Item addedItem = itemService.getItem(35);
        Assert.assertEquals(expectedItem.hashCode(), addedItem.hashCode());
        Assert.assertTrue(expectedItem.equals(addedItem));
    }
//    @Test
//    public void deleteItemTest() {
//        Item item = new Item();
//        item.setItemId(35);
//        item.setName("Nike");
//        item.setDescription("Sneakers");
//        item.setCategory("shoes");
//        item.setImage_url("http://hsdg");
//        item.setSellable(true);
//        ItemEntity itemEntity = itemService.mapTo(item);
//        //when(itemDao.deleteItem(35)).thenReturn(itemEntity);
//        itemDao.deleteItem(35);
//        Item expectedItem= null;
//        Item deletedItem = itemService.deleteItem(35);
//        Assert.assertEquals(expectedItem.hashCode(),deletedItem.hashCode());
//        //Assert.assertTrue(expectedItem.equals(deletedItem));
//          Assert.assertNull(itemEntity);
//    }

//          @Test
//      public void getAllItemTest()  {
//          Item item = new Item();
//          item.setItemId(35);
//          item.setName("Nike");
//          item.setDescription("Sneakers");
//          item.setCategory("shoes");
//          item.setImage_url("http://hsdg");
//          item.setSellable(true);
//          ItemEntity itemEntity;
//          List<ItemEntity> itemEntityList = (List<ItemEntity>) itemService.mapTo(item);
//          when(itemDao.getAllItem()).thenReturn((List<ItemEntity>) itemEntityList);
//          Item expectedItem = itemService.mapTo(itemEntityList);
//          List<ItemEntity> AllItem = itemService.getAllItem();
//          Assert.assertEquals(expectedItem.hashCode(),AllItem.hashCode());
//          Assert.assertTrue(expectedItem.equals(AllItem));
//      }
    @Test
    public void getItemByNameTest() {
        Item item = new Item();
        item.setItemId(35);
        item.setName("Nike");
        item.setDescription("Sneakers");
        item.setCategory("shoes");
        item.setImage_url("http://hsdg");
        item.setSellable(true);
        ItemEntity itemEntity = itemService.mapTo(item);
        when(itemDao.getItemByName("Nike")).thenReturn(itemEntity);
        Item expectedItem = itemService.mapTo(itemEntity);
        Item addedItem = itemService.getItemByName("Nike");
        Assert.assertEquals(expectedItem.hashCode(), addedItem.hashCode());
        Assert.assertTrue(expectedItem.equals(addedItem));
    }

//    @Test
//    public void getItemByCategoryTest()  {
//        Item item = new Item();
//        item.setItemId(35);
//        item.setName("Nike");
//        item.setDescription("Sneakers");
//        item.setCategory("shoes");
//        item.setImage_url("http://hsdg");
//        item.setSellable(true);
//        List<ItemEntity> itemEntityList = (List<ItemEntity>) itemService.mapTo(item);
//        when(itemDao.getAllItemByCategory("shoes")).thenReturn(itemEntityList);
//        Item expectedItem = (Item) itemService.getAllItemByCategory(String.valueOf(itemEntityList));
//        Item categoryItem = (Item) itemService.getAllItemByCategory("shoes");
//        Assert.assertEquals(expectedItem.hashCode(),categoryItem.hashCode());
//        Assert.assertTrue(expectedItem.equals(categoryItem));
//    }
 }

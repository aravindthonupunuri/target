package com.dojoitem.dojoitem;

import com.dojoitem.dojoitem.item.Item;
import com.dojoitem.dojoitem.service.ItemService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class ItemServiceTest {
    @Autowired
    ItemService itemService;

    Item shirtItem;
    Item shirt;

    @Before
    public void setup(){
        shirtItem = new Item(12346,"shirt","cloth","wear","htrto",true);
       //item1 = new Item(1234566890,"ghhfj","DFGHJB","FGHJHGF","HGFFGH",true);
    }
//    @Test
//    public void updateItemDetailsTest()
//    {
//        itemService.addItem(item);
//        Assert.assertTrue(itemService.updateItem(item));
//
//    }
    @Test
    public void getItemDetailsTest()
    {

        itemService.addItem(shirtItem);
        Item actualItem = itemService.getItem(12346);
        Assert.assertEquals(shirtItem.getItemId(),actualItem.getItemId());
    }

//    @Test
//    public void deleteItemDetailsTest() {
//        itemService.addItem(i);
//    }

}

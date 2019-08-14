package com.dojoitem.dojoitem;

import com.dojoitem.dojoitem.item.Item;
import com.dojoitem.dojoitem.service.ItemService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ItemServiceTest {
    @Autowired
    ItemService itemService;
    Item item;
    @Before
    public void setup(){
        item = new Item(1234,"shirt","cloth","wear","htrto",true);
    }
    @Test
    public void addItemDetailsTest()
    {
        itemService.addItem(item);
        Assert.assertTrue(itemService.updateItem(item));

    }


}

package com.dojoitem.dojoitem.controller;

import com.dojoitem.dojoitem.item.Item;
import com.dojoitem.dojoitem.repository.ItemRepository;
import com.dojoitem.dojoitem.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
public class ItemController {
    @Autowired
    ItemService itemService;
    @Autowired
    ItemRepository itemRepository;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    public ItemController() {
    }
    @GetMapping(path = "item/category/{category}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> getAllItemByCategory(@PathVariable String category)
    {
        // Item item =
        return new ResponseEntity(itemService.getAllItemByCategory(category),HttpStatus.OK);
    }
    @GetMapping(path = "item/name/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> getItemByName(@PathVariable String name){
        Item item = itemService.getItemByName(name);
        return new ResponseEntity<>(item,HttpStatus.OK);
    }
    @GetMapping(path = "item", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> getAllItem()
    {
        return new ResponseEntity(itemService.getAllItem(), HttpStatus.OK);
    }
    @GetMapping(path = "item/{item_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> getItem(@PathVariable int item_id) {
        Item item = itemService.getItem(item_id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }


    @PostMapping(path = "item/{item_id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> addItem(@PathVariable int item_id, @RequestBody Item itemRequest) {
        return new ResponseEntity<>(itemService.addItem(itemRequest), HttpStatus.CREATED);
    }

    @PutMapping(path = "item/{item_id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateItem(@PathVariable int item_id, @RequestBody Item itemRequest) {
        int state = itemService.updateItem(itemRequest);
        return new ResponseEntity<>("updatedItem" + state, HttpStatus.ACCEPTED);

    }

    @DeleteMapping(path = "item/{item_id}")
    public void deleteItem(@PathVariable int item_id){
        itemService.deleteItem(item_id);
    }

    public ItemService getItemService() {
        return itemService;
    }

    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }
}

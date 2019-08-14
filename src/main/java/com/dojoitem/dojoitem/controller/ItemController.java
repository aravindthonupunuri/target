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

import java.util.List;
import java.util.Optional;

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
    @GetMapping(path = "item/{item_Id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> getItem(@PathVariable int item_Id) {
        Item item = itemService.getItem(item_Id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }
    @GetMapping(path = "item/category/{category}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> getByCategory(@PathVariable String category){
        return new ResponseEntity(itemService.getByCategory(category), HttpStatus.OK);
//        Item item = itemService.getByCategory(category);
//        return new ResponseEntity<>(item,HttpStatus.OK);
    }

    @PostMapping(path = "item/{item_Id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> addItem(@PathVariable int item_Id, @RequestBody Item itemRequest) {
        return new ResponseEntity<>(itemService.addItem(itemRequest), HttpStatus.CREATED);
    }

    @PutMapping(path = "item/{item_Id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateItem(@PathVariable int item_Id, @RequestBody Item itemRequest) {
        boolean state = itemService.updateItem(itemRequest);
        return new ResponseEntity<>("updatedItem" + state, HttpStatus.ACCEPTED);

    }

    @DeleteMapping(path = "item/{item_Id}")
    public void deleteItem(@PathVariable int item_Id){
        itemService.deleteItem(item_Id);
    }

    public ItemService getItemService() {
        return itemService;
    }

    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }
}

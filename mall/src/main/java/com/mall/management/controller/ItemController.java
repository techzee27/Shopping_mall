package com.mall.management.controller;

import com.mall.management.entity.Item;
import com.mall.management.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public Item addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    @PutMapping
    public Item updateItem(@RequestBody Item item) {
        return itemService.updateItem(item);
    }

    @GetMapping("/{id}")
    public Item searchItem(@PathVariable Long id) {
        return itemService.searchItem(id);
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable Long id) {
        boolean isDeleted = itemService.deleteItem(id);
        if (isDeleted) {
            return "Item deleted successfully";
        } else {
            return "Item not found";
        }
    }
}

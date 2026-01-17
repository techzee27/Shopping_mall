package com.mall.management.controller;

import com.mall.management.entity.Shop;
import com.mall.management.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping
    public Shop addShop(@RequestBody Shop shop) {
        return shopService.addShop(shop);
    }

    @PutMapping
    public Shop updateShop(@RequestBody Shop shop) {
        return shopService.updateShop(shop);
    }

    @GetMapping("/{id}")
    public Shop searchShop(@PathVariable Integer id) {
        return shopService.searchShopById(id);
    }

    @GetMapping
    public List<Shop> getAllShops() {
        return shopService.getAllShops();
    }

    @DeleteMapping("/{id}")
    public String deleteShop(@PathVariable Integer id) {
        boolean isDeleted = shopService.deleteShop(id);
        if (isDeleted) {
            return "Shop deleted successfully";
        } else {
            return "Shop not found";
        }
    }
}

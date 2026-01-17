package com.mall.management.controller;

import com.mall.management.entity.ShopOwner;
import com.mall.management.service.ShopOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopOwner")
public class ShopOwnerController {

    @Autowired
    private ShopOwnerService shopOwnerService;

    @PostMapping
    public ShopOwner addShopOwner(@RequestBody ShopOwner shopOwner) {
        return shopOwnerService.addShopOwner(shopOwner);
    }

    @PutMapping
    public ShopOwner updateShopOwner(@RequestBody ShopOwner shopOwner) {
        return shopOwnerService.updateShopOwner(shopOwner);
    }

    @GetMapping("/{id}")
    public ShopOwner searchShopOwner(@PathVariable Integer id) {
        return shopOwnerService.searchShopOwner(id);
    }

    @GetMapping
    public List<ShopOwner> getAllShopOwners() {
        return shopOwnerService.getAllShopOwners();
    }

    @DeleteMapping("/{id}")
    public String deleteShopOwner(@PathVariable Integer id) {
        boolean isDeleted = shopOwnerService.deleteShopOwner(id);
        if (isDeleted) {
            return "ShopOwner deleted successfully";
        } else {
            return "ShopOwner not found";
        }
    }
}

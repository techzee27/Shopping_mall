package com.mall.management.service;

import com.mall.management.entity.Shop;
import java.util.List;

public interface ShopService {
    Shop addShop(Shop shop);

    Shop updateShop(Shop shop);

    Shop searchShopById(Integer id);

    List<Shop> getAllShops();

    boolean deleteShop(Integer id);
}

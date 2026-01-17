package com.mall.management.service;

import com.mall.management.entity.ShopOwner;
import java.util.List;

public interface ShopOwnerService {
    ShopOwner addShopOwner(ShopOwner shopOwner);

    ShopOwner updateShopOwner(ShopOwner shopOwner);

    ShopOwner searchShopOwner(Integer id);

    List<ShopOwner> getAllShopOwners();

    boolean deleteShopOwner(Integer id);
}

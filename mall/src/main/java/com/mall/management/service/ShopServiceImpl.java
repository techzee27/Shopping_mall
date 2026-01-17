package com.mall.management.service;

import com.mall.management.entity.Shop;
import com.mall.management.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@SuppressWarnings("null")
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Override
    public Shop addShop(Shop shop) {
        return shopRepository.save(shop);
    }

    @Override
    public Shop updateShop(Shop shop) {
        return shopRepository.save(shop);
    }

    @Override
    public Shop searchShopById(Integer id) {
        return shopRepository.findById(id).orElse(null);
    }

    @Override
    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    @Override
    public boolean deleteShop(Integer id) {
        if (shopRepository.existsById(id)) {
            shopRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

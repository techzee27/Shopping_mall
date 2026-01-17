package com.mall.management.service;

import com.mall.management.entity.ShopOwner;
import com.mall.management.repository.ShopOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@SuppressWarnings("null")
public class ShopOwnerServiceImpl implements ShopOwnerService {

    @Autowired
    private ShopOwnerRepository shopOwnerRepository;

    @Override
    public ShopOwner addShopOwner(ShopOwner shopOwner) {
        return shopOwnerRepository.save(shopOwner);
    }

    @Override
    public ShopOwner updateShopOwner(ShopOwner shopOwner) {
        return shopOwnerRepository.save(shopOwner);
    }

    @Override
    public ShopOwner searchShopOwner(Integer id) {
        return shopOwnerRepository.findById(id).orElse(null);
    }

    public boolean deleteShopOwner(Integer id) {
        if (shopOwnerRepository.existsById(id)) {
            shopOwnerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<ShopOwner> getAllShopOwners() {
        return shopOwnerRepository.findAll();
    }
}

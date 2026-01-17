package com.mall.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mall.management.entity.ShopOwner;

@Repository
public interface ShopOwnerRepository extends JpaRepository<ShopOwner, Integer> {
}

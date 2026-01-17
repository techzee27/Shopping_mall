package com.mall.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mall.management.entity.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {
}

package com.mall.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mall.management.entity.MallAdmin;

@Repository
public interface MallAdminRepository extends JpaRepository<MallAdmin, Integer> {
}

package com.mall.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mall.management.entity.Mall;

@Repository
public interface MallRepository extends JpaRepository<Mall, Long> {
}

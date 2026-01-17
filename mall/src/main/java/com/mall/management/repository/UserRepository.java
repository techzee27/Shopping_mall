package com.mall.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mall.management.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}

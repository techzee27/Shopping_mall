package com.mall.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mall.management.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

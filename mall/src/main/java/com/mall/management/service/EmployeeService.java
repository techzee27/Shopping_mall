package com.mall.management.service;

import com.mall.management.entity.Employee;
import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    Employee searchEmployee(Integer id);

    List<Employee> getAllEmployees();

    boolean deleteEmployee(Integer id);
}

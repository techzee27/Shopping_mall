package com.mall.management.controller;

import com.mall.management.entity.Employee;
import com.mall.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee searchEmployee(@PathVariable Integer id) {
        return employeeService.searchEmployee(id);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        boolean isDeleted = employeeService.deleteEmployee(id);
        if (isDeleted) {
            return "Employee deleted successfully";
        } else {
            return "Employee not found";
        }
    }
}

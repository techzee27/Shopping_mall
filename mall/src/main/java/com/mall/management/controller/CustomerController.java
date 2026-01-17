package com.mall.management.controller;

import com.mall.management.entity.Customer;
import com.mall.management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @PutMapping
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer searchCustomer(@PathVariable Integer id) {
        return customerService.searchCustomer(id);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        boolean isDeleted = customerService.deleteCustomer(id);
        if (isDeleted) {
            return "Customer deleted successfully";
        } else {
            return "Customer not found";
        }
    }
}

package com.mall.management.service;

import com.mall.management.entity.Customer;
import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    Customer searchCustomer(Integer id);

    List<Customer> getAllCustomers();

    boolean deleteCustomer(Integer id);
}

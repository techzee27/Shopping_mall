package com.mall.management.controller;

import com.mall.management.entity.OrderDetails;
import com.mall.management.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService orderDetailsService;

    @PostMapping
    public OrderDetails addOrder(@RequestBody OrderDetails orderDetails) {
        return orderDetailsService.addOrder(orderDetails);
    }

    @PutMapping
    public OrderDetails updateOrder(@RequestBody OrderDetails orderDetails) {
        return orderDetailsService.updateOrder(orderDetails);
    }

    @GetMapping("/{id}")
    public OrderDetails searchOrder(@PathVariable Integer id) {
        return orderDetailsService.searchOrder(id);
    }

    @GetMapping
    public List<OrderDetails> getAllOrders() {
        return orderDetailsService.getAllOrders();
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Integer id) {
        boolean isDeleted = orderDetailsService.deleteOrder(id);
        if (isDeleted) {
            return "Order deleted successfully";
        } else {
            return "Order not found";
        }
    }
}

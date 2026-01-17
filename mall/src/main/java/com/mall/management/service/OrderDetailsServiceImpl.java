package com.mall.management.service;

import com.mall.management.entity.OrderDetails;
import com.mall.management.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@SuppressWarnings("null")
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Override
    public OrderDetails addOrder(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    @Override
    public OrderDetails updateOrder(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    @Override
    public OrderDetails searchOrder(Integer id) {
        return orderDetailsRepository.findById(id).orElse(null);
    }

    @Override
    public List<OrderDetails> getAllOrders() {
        return orderDetailsRepository.findAll();
    }

    @Override
    public boolean deleteOrder(Integer id) {
        if (orderDetailsRepository.existsById(id)) {
            orderDetailsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

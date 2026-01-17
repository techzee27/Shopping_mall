package com.mall.management.service;

import com.mall.management.entity.OrderDetails;
import java.util.List;

public interface OrderDetailsService {
    OrderDetails addOrder(OrderDetails orderDetails);

    OrderDetails updateOrder(OrderDetails orderDetails);

    OrderDetails searchOrder(Integer id);

    List<OrderDetails> getAllOrders();

    boolean deleteOrder(Integer id);
}

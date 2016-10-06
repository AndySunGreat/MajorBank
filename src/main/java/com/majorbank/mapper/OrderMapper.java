package com.majorbank.mapper;

import com.majorbank.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by AndySun on 2016/10/2.
 */
@Repository
public interface OrderMapper {
    List<Order> getAllOrders(Order order);
    void insertOrder(Order order);
    Order getOrderById(long orderId);
    void updateOrder(Order order);
    void deleteOrder(long orderId);
}

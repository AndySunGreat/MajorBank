package com.majorbank.service;

import com.majorbank.model.Order;

import java.util.List;

/**
 * Created by AndySun on 2016/10/6.
 */
public interface OrderService {
    List<Order> getAllOrders(Order orderObj);
    void insertOrder(Order orderObj);
    Order getOrderById(long orderId);
    void updateOrder(Order orderObj);
    void deleteOrder(long orderId);
}

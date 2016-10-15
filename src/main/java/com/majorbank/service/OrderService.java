package com.majorbank.service;

import com.majorbank.model.Orders;

import java.util.List;

/**
 * Created by AndySun on 2016/10/6.
 */
public interface OrderService {
    List<Orders> getAllOrders(Orders orderObj);
    Orders insertOrder(Orders orderObj);
    Orders getOrderById(long orderId);
    int updateOrder(Orders orderObj);
    int deleteOrder(long orderId);
}

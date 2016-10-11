package com.majorbank.mapper;

import com.majorbank.model.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by AndySun on 2016/10/2.
 */
@Repository
public interface OrderMapper {
    List<Orders> getAllOrders(Orders order);
    void insertOrder(Orders order);
    Orders getOrderById(long orderId);
    void updateOrder(Orders order);
    void deleteOrder(long orderId);
}

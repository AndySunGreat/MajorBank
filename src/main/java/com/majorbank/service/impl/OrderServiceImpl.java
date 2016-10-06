package com.majorbank.service.impl;

import com.majorbank.mapper.OrderMapper;
import com.majorbank.mapper.OrderMapper;
import com.majorbank.model.Order;
import com.majorbank.service.OrderService;
import com.majorbank.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by AndySun on 2016/10/6.
 */
@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public List<Order> getAllOrders(Order order){
        return orderMapper.getAllOrders(order);
    }
    public void insertOrder(Order order){
        orderMapper.insertOrder(order);
    }

    public Order getOrderById(long orderId){
        return orderMapper.getOrderById(orderId);
    }

    public void updateOrder(Order order){
        orderMapper.updateOrder(order);
    }

    public void deleteOrder(long orderId){
        orderMapper.deleteOrder(orderId);
    }
    
}

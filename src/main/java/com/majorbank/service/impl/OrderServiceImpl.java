package com.majorbank.service.impl;

import com.majorbank.mapper.OrderMapper;
import com.majorbank.mapper.OrderMapper;
import com.majorbank.model.Orders;
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

    public List<Orders> getAllOrders(Orders order){
        return orderMapper.getAllOrders(order);
    }
    public Orders insertOrder(Orders order){
        orderMapper.insertOrder(order);
        return order;
    }

    public Orders getOrderById(long orderId){
        return orderMapper.getOrderById(orderId);
    }

    public void updateOrder(Orders order){

        orderMapper.updateOrder(order);
    }

    public void deleteOrder(long orderId){
        orderMapper.deleteOrder(orderId);
    }
    
}

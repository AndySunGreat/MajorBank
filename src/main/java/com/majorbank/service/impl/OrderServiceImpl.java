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

    public int updateOrder(Orders order){

        int updateRst = orderMapper.updateOrder(order);
        return updateRst;
    }

    public int deleteOrder(long orderId){
        return  orderMapper.deleteOrder(orderId);
    }
    
}

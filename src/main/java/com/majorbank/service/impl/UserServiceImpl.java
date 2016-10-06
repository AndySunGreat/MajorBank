package com.majorbank.service.impl;

import com.majorbank.mapper.UserMapper;
import com.majorbank.model.Order;
import com.majorbank.model.QuestBank;
import com.majorbank.model.User;
import com.majorbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by AndySun on 2016/10/2.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUsers(User user){
        return userMapper.getAllUsers(user);
    }

    public void insertUser(User user){
        userMapper.insertUser(user);
    }

    public User getUserById(long userId){
        return userMapper.getUserById(userId);
    }

    public void updateUser(User user){
        userMapper.updateUser(user);
    }

    public void deleteUser(long userId){
        userMapper.deleteUser(userId);
    }

    public List<Order> getAllOrderByUserId(long userId,String orderType){
        Order order = new Order();
        order.setUserId(userId);
        order.setOrderType(orderType);
        return userMapper.getAllOrderByUserId(order);
    }

    public Order getOrderByIds(long userId, long orderId){
        return userMapper.getOrderByIds(userId,orderId);
    }

}

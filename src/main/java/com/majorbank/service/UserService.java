package com.majorbank.service;

import com.majorbank.model.Orders;
import com.majorbank.model.QuestBank;
import com.majorbank.model.User;

import java.util.List;

/**
 * Created by AndySun on 2016/10/2.
 */

public interface UserService {
    List<User> getAllUsers(User user);
    void insertUser(User user);
    User getUserById(long userId);
    void updateUser(User user);
    void deleteUser(long userId);
    List<Orders> getAllOrderByUserId(long userId,String orderType);
    Orders getOrderByIds(long userId, long orderId);
}

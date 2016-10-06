package com.majorbank.service;

import com.majorbank.model.Order;
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
    List<Order> getAllOrderByUserId(long userId,String orderType);
    Order getOrderByIds(long userId, long orderId);
}

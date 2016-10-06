package com.majorbank.mapper;

import com.majorbank.model.Order;
import com.majorbank.model.QuestBank;
import com.majorbank.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by AndySun on 2016/10/2.
 */
@Repository
public interface UserMapper {
    List<User> getAllUsers(User user);
    void insertUser(User user);
    User getUserById(long userId);
    void updateUser(User user);
    void deleteUser(long userId);
    List<Order> getAllOrderByUserId(Order order);
    Order getOrderByIds(long userId, long orderId);
}

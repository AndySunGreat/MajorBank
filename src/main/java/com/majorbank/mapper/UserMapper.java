package com.majorbank.mapper;

import com.majorbank.model.Orders;
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
    int insertUser(User user);
    User getUserById(long userId);
    int updateUser(User user);
    int deleteUser(long userId);
    List<Orders> getAllOrderByUserId(Orders order);
    Orders getOrderByIds(long userId, long orderId);
}

package com.majorbank.service;

import com.majorbank.model.QuestBank;
import com.majorbank.model.User;
import com.majorbank.model.UserFilter;
import org.springframework.stereotype.Service;

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
    List<QuestBank> getAllBankByUserId(long userId);
    QuestBank getBankByIds(long userId,long bankId);
}

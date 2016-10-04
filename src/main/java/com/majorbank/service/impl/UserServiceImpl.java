package com.majorbank.service.impl;

import com.majorbank.mapper.UserMapper;
import com.majorbank.model.QuestBank;
import com.majorbank.model.User;
import com.majorbank.model.UserFilter;
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

    public void createUser(User user){
        userMapper.createUser(user);
    }

    public User getUserById(long userId){
        return userMapper.getUserById(userId);
    }

    public void updateUser(long userId){
        userMapper.updateUser(userId);
    }

    public void deleteUser(long userId){
        userMapper.deleteUser(userId);
    }
    public List<QuestBank> getAllBankByUserId(long userId){
        return userMapper.getAllBankByUserId(userId);
    }
    public QuestBank getBankByIds(long userId,long bankId){
        return userMapper.getBankByIds(userId,bankId);
    }

}

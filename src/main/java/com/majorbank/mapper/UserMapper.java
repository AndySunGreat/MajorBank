package com.majorbank.mapper;

import com.majorbank.model.QuestBank;
import com.majorbank.model.User;
import com.majorbank.model.UserFilter;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by AndySun on 2016/10/2.
 */
@Repository
public interface UserMapper {
    List<User> getAllUsers(User user);
    void createUser(User user);
    User getUserById(long userId);
    void updateUser(long userId);
    void deleteUser(long userId);
    List<QuestBank> getAllBankByUserId(long userId);
    QuestBank getBankByIds(long userId,long bankId);
}

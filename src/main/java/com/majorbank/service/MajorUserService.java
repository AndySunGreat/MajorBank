package com.majorbank.service;

import com.majorbank.model.MajorUser;
import com.majorbank.model.Orders;
import com.majorbank.model.User;

import java.util.List;

/**
 * Created by AndySun on 2016/10/2.
 */

public interface MajorUserService {

    List<MajorUser> getAllMajorUsers(MajorUser majorUser);
    int insertMajorUser(MajorUser majorUser);
    MajorUser getMajorUserById(long userId);
    int updateMajorUser(MajorUser majorUser);
    int deleteMajorUser(long userId);
}

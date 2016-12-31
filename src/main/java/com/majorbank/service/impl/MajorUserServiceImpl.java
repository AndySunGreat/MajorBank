package com.majorbank.service.impl;

import com.majorbank.mapper.MajorUserMapper;
import com.majorbank.mapper.UserMapper;
import com.majorbank.model.MajorUser;
import com.majorbank.model.Orders;
import com.majorbank.model.User;
import com.majorbank.service.MajorUserService;
import com.majorbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by AndySun on 2016/10/2.
 */
@Service("majorUserService")
@Transactional
public class MajorUserServiceImpl implements MajorUserService {
    @Autowired
    private MajorUserMapper majorUserMapper;

    public List<MajorUser> getAllMajorUsers(MajorUser majorUser){
        return majorUserMapper.getAllMajorUsers(majorUser);
    }

    public int insertMajorUser(MajorUser majorUser){
        return majorUserMapper.insertMajorUser(majorUser);
    }

    public MajorUser getMajorUserById(long userId){
        return majorUserMapper.getMajorUserById(userId);
    }

    public int updateMajorUser(MajorUser majorUser){
        return majorUserMapper.updateMajorUser(majorUser);
    }

    public int deleteMajorUser(long userId){
        return majorUserMapper.deleteMajorUser(userId);
    }
}

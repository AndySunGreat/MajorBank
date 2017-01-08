package com.majorbank.controller;

import com.majorbank.model.MajorUser;
import com.majorbank.model.User;
import com.majorbank.service.MajorUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by AndySun on 2016/10/3.
 */
@Controller
@RequestMapping("/api/login")
public class MajorUserController {
    private static final Logger LOG = LoggerFactory.getLogger(MajorUserController.class);
    @Autowired
    private MajorUserService majorUserService;
    /**
     * list all user
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/majoruser"},method = {RequestMethod.GET})
    public List<MajorUser> getAllMajorUsers(@RequestParam(required = false) String majorId,
                                            @RequestParam(required = false) String userName,
                                            @RequestParam(required = false) String passWord,
                                            @RequestParam(required = false) String industryTypeRole,
                                            @RequestParam(required = false) String qbCategoryRole,
                                            @RequestParam(required = false) String qbTypeRole,
                                            @RequestParam(required = false) String bankRole){
        MajorUser majorUser = new MajorUser();
        if(majorId!=null){
            majorUser.setId(Long.parseLong(majorId));
        }
        if(userName!=null){
            majorUser.setUsername(userName);
        }
        if(passWord!=null){
            majorUser.setPassword(passWord);
        }
        if(industryTypeRole!=null){
            majorUser.setIndustryTypeRole(industryTypeRole);
        }
        if(qbCategoryRole!=null){
            majorUser.setQbCategoryRole(qbCategoryRole);
        }
        if(qbTypeRole!=null){
            majorUser.setQbTypeRole(qbTypeRole);
        }
        if(bankRole!=null){
            majorUser.setBankRole(bankRole);
        }
        List<MajorUser> majorUserList = majorUserService.getAllMajorUsers(majorUser);
        return majorUserList;
    }

    /**
     * create one user
     * ps: Content-Type要用application/json,Body选raw写入json才可以
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/majoruser"},method = {RequestMethod.POST})
    public void insertMajorUser(@RequestBody MajorUser majorUser){
        majorUserService.insertMajorUser(majorUser);
    }

    /**
     * get one  user
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/majoruser/{userId}"},method = {RequestMethod.GET})
    public MajorUser getMajorUserById(@PathVariable long userId){
        MajorUser majorUser = majorUserService.getMajorUserById(userId);
        return majorUser;
    }

    @GetMapping("/majoruser/validate")
    public ResponseEntity validateLogins(
            @RequestParam("accountNumber") String strAcctNumber,
            @RequestParam("password") String strPWD){
        MajorUser majorUser = new MajorUser();
        majorUser.setUsername(strAcctNumber);
        majorUser.setPassword(strPWD);
        List<MajorUser> userList = majorUserService.getAllMajorUsers(majorUser);
        if (userList == null|| userList.size()==0) {
            return new ResponseEntity("200B - No Major User found for AccountNumber " + strAcctNumber, HttpStatus.NOT_FOUND);
        }else{
            if(userList.size()>0) {
                if (!userList.get(0).getPassword().equals(strPWD)) {
                    return new ResponseEntity("200C - Password is incorrect " + strAcctNumber, HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity(userList.get(0), HttpStatus.OK);
    }

    /***
     * update user info
     * @param userId
     */
    @ResponseBody
    @RequestMapping(value={"/majoruser/{userId}"},method = {RequestMethod.PUT})
    public void updateMajorUser(@PathVariable long userId,
                           @RequestBody MajorUser majorUser){
        if(majorUser.getId()==0L){
            majorUser.setId(userId);
        }
        LOG.debug("user.getId():"+majorUser.getId());
        majorUserService.updateMajorUser(majorUser);
    }

    /***
     * delete user info
     * @param userId
     */
    @ResponseBody
    @RequestMapping(value={"/majoruser/{userId}"},method = {RequestMethod.DELETE})
    public void deleteMajorUser(@PathVariable long userId){
        majorUserService.deleteMajorUser(userId);
    }

}

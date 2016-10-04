package com.majorbank.controller;

import com.majorbank.model.QuestBank;
import com.majorbank.model.User;
import com.majorbank.model.UserFilter;
import com.majorbank.service.UserService;
import com.majorbank.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by AndySun on 2016/10/3.
 */
@Controller
@RequestMapping("/api/login")
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    /**
     * list all user
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/user"},method = {RequestMethod.GET})
    public List<User> getAllUsers(){
        List<User> userList = userService.getAllUsers(null);
        return userList;
    }

    /**
     * create one user
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/user"},method = {RequestMethod.POST})
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }

    /**
     * get one  user
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/user/{userId}"},method = {RequestMethod.GET})
    public User getUserById(@PathVariable long userId){
        User user = userService.getUserById(userId);
        return user;
    }

    @GetMapping("/user/validate")
    public ResponseEntity validateLogins(
            @RequestParam("accountNumber") String strAcctNumber,
            @RequestParam("password") String strPWD){
        User user = new User();
        user.setUsername(strAcctNumber);
        user.setPassword(strPWD);
        List<User> userList = userService.getAllUsers(user);
        if (userList == null) {
            return new ResponseEntity("200B - No UserNew found for AccountNumber " + strAcctNumber, HttpStatus.NOT_FOUND);
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
    @RequestMapping(value={"/user/{userId}"},method = {RequestMethod.PUT})
    public void updateUser(@PathVariable long userId){
        userService.updateUser(userId);
    }

    /***
     * delete user info
     * @param userId
     */
    @ResponseBody
    @RequestMapping(value={"/user/{userId}"},method = {RequestMethod.DELETE})
    public void deleteUser(@PathVariable long userId){
        userService.deleteUser(userId);
    }

    /**
     * 获得某个用户的所有题库
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/user/{userId}/questbank"},method = {RequestMethod.GET})
    public List<QuestBank> getAllBankByUserId(@PathVariable long userId){
        List<QuestBank> questBankList = userService.getAllBankByUserId(userId);
        return questBankList;
    }
    /**
     * 获得某个用户的某个题库
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/user/{userId}/questbank/{bankId}"},method = {RequestMethod.GET})
    public QuestBank getBankByIds(@PathVariable long userId,@PathVariable long bankId){
        QuestBank questBank = userService.getBankByIds(userId,bankId);
        return questBank;
    }
}

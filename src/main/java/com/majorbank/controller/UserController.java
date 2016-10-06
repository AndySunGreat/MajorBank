package com.majorbank.controller;

import com.majorbank.model.Order;
import com.majorbank.model.QuestBank;
import com.majorbank.model.User;
import com.majorbank.service.UserService;
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
     * ps: Content-Type要用application/json,Body选raw写入json才可以
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/user"},method = {RequestMethod.POST})
    public void insertUser(@RequestBody User user){
        userService.insertUser(user);
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
    public void updateUser(@PathVariable long userId,
                           @RequestBody User user){
        if(user.getId()==0L){
            user.setId(userId);
        }
        LOG.debug("user.getId():"+user.getId());
        userService.updateUser(user);
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
    @RequestMapping(value={"/user/{userId}/order/{orderType}"},method = {RequestMethod.GET})
    public List<Order> getAllOrderByUserId(@PathVariable long userId,
                                           @PathVariable String orderType){
        List<Order> orderBankList = userService.getAllOrderByUserId(userId,orderType);
        return orderBankList;
    }
    /**
     * 获得某个用户的某个订单
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/user/{userId}/order/{orderId}"},method = {RequestMethod.GET})
    public Order getOrderByIds(@PathVariable long userId, @PathVariable long orderId){
        Order order = userService.getOrderByIds(userId,orderId);
        return order;
    }
}

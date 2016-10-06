package com.majorbank.controller;

import com.majorbank.model.Order;
import com.majorbank.model.QuestBank;
import com.majorbank.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by AndySun on 2016/10/3.
 */
@Controller
@RequestMapping("/api/me")
public class OrderController {
    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    /**
     * list all Order
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/order"},method = {RequestMethod.GET})
    public List<Order> getAllOrders(){
        List<Order> orderList = orderService.getAllOrders(null);
        return orderList;
    }

    /**
     * create one Order
     * ps: Content-Type要用application/json,Body选raw写入json才可以
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/order"},method = {RequestMethod.POST})
    public void insertOrder(@RequestBody Order order){

        orderService.insertOrder(order);
    }

    /**
     * get one  Order
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/order/{orderId}"},method = {RequestMethod.GET})
    public Order getOrderById(@PathVariable long orderId){
        Order Order = orderService.getOrderById(orderId);
        return Order;
    }

    /***
     * update Order info
     * @param orderId
     */
    @ResponseBody
    @RequestMapping(value={"/order/{orderId}"},method = {RequestMethod.PUT})
    public void updateOrder(@PathVariable long orderId,
                           @RequestBody Order order){
        if(order.getOrderId()==0L){
            order.setOrderId(orderId);
        }
        LOG.debug("package.getOrderId():"+order.getOrderId());
        orderService.updateOrder(order);
    }

    /***
     * delete Order info
     * @param orderId
     */
    @ResponseBody
    @RequestMapping(value={"/order/{orderId}"},method = {RequestMethod.DELETE})
    public void deleteOrder(@PathVariable long orderId){
        orderService.deleteOrder(orderId);
    }


}

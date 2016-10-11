package com.majorbank.controller;

import com.majorbank.model.Orders;
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
public class OrdersController {
    private static final Logger LOG = LoggerFactory.getLogger(OrdersController.class);

    @Autowired
    private OrderService orderService;

    /**
     * list all Order
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/orders"},method = {RequestMethod.GET})
    public List<Orders> getAllOrders(){
        List<Orders> orderList = orderService.getAllOrders(null);
        return orderList;
    }

    /**
     * create one Order
     * ps: Content-Type要用application/json,Body选raw写入json才可以
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/orders"},method = {RequestMethod.POST})
    public void insertOrder(@RequestBody Orders order){

        orderService.insertOrder(order);
    }

    /**
     * get one  Order
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/orders/{orderId}"},method = {RequestMethod.GET})
    public Orders getOrderById(@PathVariable long orderId){
        Orders Order = orderService.getOrderById(orderId);
        return Order;
    }

    /***
     * update Order info
     * @param orderId
     */
    @ResponseBody
    @RequestMapping(value={"/orders/{orderId}"},method = {RequestMethod.PUT})
    public void updateOrder(@PathVariable long orderId,
                           @RequestBody Orders order){
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
    @RequestMapping(value={"/orders/{orderId}"},method = {RequestMethod.DELETE})
    public void deleteOrder(@PathVariable long orderId){
        orderService.deleteOrder(orderId);
    }


}

package com.majorbank.controller;

import com.majorbank.model.Orders;
import com.majorbank.service.OrderService;
import net.sf.json.JSONObject;
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
    public List<Orders> getAllOrders(@RequestParam(required = false) String orderId,
                                     @RequestParam(required = false) String userId,
                                     @RequestParam(required = false) String orderType,
                                     @RequestParam(required = false) String orderStatus,
                                     @RequestParam(required = false) String bankId,
                                     @RequestParam(required = false) String answerId,
                                     @RequestParam(required = false) String packageId){
        Orders orders = new Orders();
        if(orderId!=null){
            orders.setOrderId(Long.valueOf(orderId));
        }
        if(userId!=null){
            orders.setUserId(Long.valueOf(userId));
        }
        if(packageId!=null) {
            orders.setPackageId(packageId);
        }
        if(orderType!=null){
            orders.setOrderType(orderType);
        }
        if(orderStatus!=null){
            orders.setOrderStatus(orderStatus);
        }
        if(bankId!=null){
            orders.setBankId(bankId);
        }
        if(answerId!=null){
            orders.setAnswerId(answerId);
        }
        List<Orders> orderList = orderService.getAllOrders(orders);
        return orderList;
    }

    /**
     * create one Order
     * ps: Content-Type要用application/json,Body选raw写入json才可以
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/orders"},method = {RequestMethod.POST})
    public Orders insertOrder(@RequestBody Orders order){
        return orderService.insertOrder(order);
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
     */
    @PutMapping("/orders/{orderId}")
    public ResponseEntity updateOrder(@PathVariable long orderId,
                                      @RequestBody Orders order1){
        if(order1.getOrderId()==0L){
            order1.setOrderId(orderId);
        }
        JSONObject jsonObject = new JSONObject();
        LOG.debug("package.getOrderId():"+order1.getOrderId());
        int updateResult = orderService.updateOrder(order1);
        if(updateResult>0){
            jsonObject.put("orderId",orderId);
            jsonObject.put("answerId",order1.getAnswerId());
            jsonObject.put("orderStatus",order1.getOrderStatus());
            jsonObject.put("msg","Update Order status of "+ updateResult+" Record successfully!");
            return  new ResponseEntity(jsonObject,HttpStatus.OK);
            //return new ResponseEntity("{\"orderId\":\""+orderId+"\"," +
             //       "{\"answerId\":\""+order1.getAnswerId()+"\"," +
              //      "\"msg\":\"Update Order status of " + updateResult+" Record successfully!\"}",HttpStatus.OK);
        }else{
            jsonObject.put("msg","Update Order status failure!");
            return new ResponseEntity(jsonObject,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /***
     * delete Order info
     * @param orderId
     */
    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity deleteOrder(@PathVariable long orderId){
        int deleteResult = orderService.deleteOrder(orderId);
        if(deleteResult>0){
            return new ResponseEntity("Delete Order of " + deleteResult+" Record successfully!", HttpStatus.OK);
        }else{
            return new ResponseEntity("Delete Order Record failure!",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

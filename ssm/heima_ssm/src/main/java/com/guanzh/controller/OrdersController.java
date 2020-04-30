package com.guanzh.controller;


import com.github.pagehelper.PageInfo;
import com.guanzh.domain.Orders;
import com.guanzh.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    //查询全部订单------未分页
    /*@RequestMapping("/findAll")
    public String findAll(Model model){
        List<Orders> ordersList = ordersService.findAll();
        model.addAttribute("ordersList",ordersList);
        return "orders-list";
    }*/

    //查询全部订单------分页
    @RequestMapping("/findAll")
    public String findAll(Model model,
                          @RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                          @RequestParam(name = "size",required = true,defaultValue = "5") Integer size) {
        List<Orders> ordersList = ordersService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(ordersList);
        model.addAttribute("pageInfo",pageInfo);
        return "orders-list";
    }

    //根据订单id查询
    @RequestMapping("/findById")
    public String findById(Model model, @RequestParam(name = "id") String ordersId){
        Orders orders = ordersService.findById(ordersId);
        model.addAttribute("orders",orders);
        return "orders-show";
    }


}

package com.geekster.Restaurant_Management_Service.controller;

import com.geekster.Restaurant_Management_Service.model.OrderFood;
import com.geekster.Restaurant_Management_Service.service.AuthenticationService;
import com.geekster.Restaurant_Management_Service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("{userEmail}/{token}")
    public String orderFood(@PathVariable String userEmail, @PathVariable String token, @RequestBody OrderFood orderFood){

        if(authenticationService.authenticateUser(userEmail, token)) {
            return orderService.orderFood(orderFood);
        }else{
            return "Enter a valid Data";
        }
    }
}


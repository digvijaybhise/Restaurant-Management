package com.geekster.Restaurant_Management_Service.controller;

import com.geekster.Restaurant_Management_Service.model.Admin;
import com.geekster.Restaurant_Management_Service.model.OrderStatus;
import com.geekster.Restaurant_Management_Service.model.User;
import com.geekster.Restaurant_Management_Service.service.AdminService;
import com.geekster.Restaurant_Management_Service.service.OrderService;
import com.geekster.Restaurant_Management_Service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @PostMapping
    public void addAdmin(@RequestBody Admin admin){
        adminService.addAdmin(admin);
    }

    @GetMapping("users/{adminEmail}")
    public List<User> getAllUser(@PathVariable String adminEmail){

        if(adminService.checkAdmin(adminEmail)) {
            return userService.getAllUsers();
        }else {
            return null;
        }
    }

    //Update Order Status
    @PutMapping("order/{orderId}/status/{orderStatus}")
    public String updateOrder(@PathVariable Integer orderId, @PathVariable OrderStatus orderStatus){
        return orderService.updateStatus(orderId, orderStatus);
    }
}

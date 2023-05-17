package com.geekster.Restaurant_Management_Service.controller;

import com.geekster.Restaurant_Management_Service.model.Food;
import com.geekster.Restaurant_Management_Service.model.Restaurant;
import com.geekster.Restaurant_Management_Service.repository.IFoodRepository;
import com.geekster.Restaurant_Management_Service.service.AdminService;
import com.geekster.Restaurant_Management_Service.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("restaurants")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    AdminService adminService;

    @Autowired
    IFoodRepository foodRepository;

    @PostMapping("/add/{adminEmail}")
    public ResponseEntity<String> addRestaurant(@PathVariable String adminEmail, @RequestBody Restaurant restaurant){
        String response;
        HttpStatus status;

        if (adminService.checkAdmin(adminEmail)) {
            restaurantService.addRestaurant(restaurant);
            response = "Restaurant added successfully";
            status = HttpStatus.ACCEPTED;
        }else{
            response = "You're not an admin.... Only admins can add restaurants";
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<String>(response, status);
    }
}

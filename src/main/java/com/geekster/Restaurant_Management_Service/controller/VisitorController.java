package com.geekster.Restaurant_Management_Service.controller;

import com.geekster.Restaurant_Management_Service.model.Food;
import com.geekster.Restaurant_Management_Service.model.Restaurant;
import com.geekster.Restaurant_Management_Service.service.RestaurantService;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("visitor")
public class VisitorController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping
    public List<Restaurant> restaurantList(){
        return restaurantService.getAll();
    }

    @GetMapping("menu/{restaurantId}")
    public List<Food> getMenu(@PathVariable Integer restaurantId){
        return restaurantService.getMenu(restaurantId);
    }
}

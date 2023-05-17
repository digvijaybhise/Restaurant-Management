package com.geekster.Restaurant_Management_Service.service;

import com.geekster.Restaurant_Management_Service.model.Food;
import com.geekster.Restaurant_Management_Service.model.Restaurant;
import com.geekster.Restaurant_Management_Service.repository.IRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    IRestaurantRepository restaurantRepository;
    
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    public List<Food> getMenu(Integer restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        return restaurant.getFood();
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }
}

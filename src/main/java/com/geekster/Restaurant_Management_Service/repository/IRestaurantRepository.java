package com.geekster.Restaurant_Management_Service.repository;

import com.geekster.Restaurant_Management_Service.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRestaurantRepository extends JpaRepository<Restaurant,Integer> {

    public Restaurant findByRestaurantName(String restaurantName);
}

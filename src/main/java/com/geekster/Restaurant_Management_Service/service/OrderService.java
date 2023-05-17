package com.geekster.Restaurant_Management_Service.service;

import com.geekster.Restaurant_Management_Service.model.*;
import com.geekster.Restaurant_Management_Service.repository.IFoodRepository;
import com.geekster.Restaurant_Management_Service.repository.IOrderRepository;
import com.geekster.Restaurant_Management_Service.repository.IRestaurantRepository;
import com.geekster.Restaurant_Management_Service.repository.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    IOrderRepository orderRepository;

    @Autowired
    IRestaurantRepository restaurantRepository;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IFoodRepository foodRepository;

    public String orderFood(OrderFood orderFood) {
        Restaurant restaurant = restaurantRepository.findById(orderFood.getRestaurant().getRestaurantId()).get();
        Food food = foodRepository.findById(orderFood.getFood().getFoodId()).get();
        User user = userRepository.findById(orderFood.getUser().getUserId()).get();

        orderFood.setRestaurant(restaurant);
        orderFood.setUser(user);
        orderFood.setFood(food);

        orderRepository.save(orderFood);
        return "Your order is placed!!";
    }

    @Transactional
    public String updateStatus(Integer orderId, OrderStatus orderStatus) {
        OrderFood order = orderRepository.findById(orderId).get();
        order.setStatus(orderStatus);
        return "You're order is Updated !!!";
    }
}

package com.geekster.Restaurant_Management_Service.repository;

import com.geekster.Restaurant_Management_Service.model.OrderFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<OrderFood, Integer> {
}

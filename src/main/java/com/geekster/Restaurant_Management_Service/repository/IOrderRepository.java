package com.geekster.Restaurant_Management_Service.repository;

import com.geekster.Restaurant_Management_Service.model.OrderFood;
import com.geekster.Restaurant_Management_Service.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IOrderRepository extends JpaRepository<OrderFood, Integer> {

//    @Modifying
//    @Query(value = "Update order_food set status = :orderStatus where order_id = :orderId", nativeQuery = true)
//    public void updateOrderStatusByOrderId(OrderStatus orderStatus, Integer orderId);
}

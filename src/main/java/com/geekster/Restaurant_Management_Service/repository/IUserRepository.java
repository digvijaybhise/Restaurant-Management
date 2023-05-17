package com.geekster.Restaurant_Management_Service.repository;

import com.geekster.Restaurant_Management_Service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {

    public boolean existsByUserEmail(String userEmail);

    public User findByUserEmail(String userEmail);
}

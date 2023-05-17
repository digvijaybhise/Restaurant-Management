package com.geekster.Restaurant_Management_Service.repository;

import com.geekster.Restaurant_Management_Service.model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthenticationRepository extends JpaRepository<AuthenticationToken, Integer> {

    public AuthenticationToken findByToken(String token);
}

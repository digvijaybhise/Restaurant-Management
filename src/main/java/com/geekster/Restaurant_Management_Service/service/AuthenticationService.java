package com.geekster.Restaurant_Management_Service.service;

import com.geekster.Restaurant_Management_Service.model.AuthenticationToken;
import com.geekster.Restaurant_Management_Service.repository.IAdminRepository;
import com.geekster.Restaurant_Management_Service.repository.IAuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    IAuthenticationRepository authenticationRepository;

    public boolean authenticateUser(String userEmail, String token) {
        AuthenticationToken token1 = authenticationRepository.findByToken(token);
        String expectedEmail = token1.getUser().getUserEmail();
        return  expectedEmail.equals(userEmail);
    }
}

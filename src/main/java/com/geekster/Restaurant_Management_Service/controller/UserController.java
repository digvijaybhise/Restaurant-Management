package com.geekster.Restaurant_Management_Service.controller;

import com.geekster.Restaurant_Management_Service.dto.SignInInput;
import com.geekster.Restaurant_Management_Service.dto.SignUpInput;
import com.geekster.Restaurant_Management_Service.model.User;
import com.geekster.Restaurant_Management_Service.service.AuthenticationService;
import com.geekster.Restaurant_Management_Service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("signup")
    public ResponseEntity<String> signup(@RequestBody SignUpInput signUpDto){

        String response;
        HttpStatus status;

        try{
            userService.signUp(signUpDto);
            response = "Sign up successful";
            status = HttpStatus.CREATED;
        }catch (Exception e){
            response = "Enter Valid Data";
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<String>(response, status);
    }

    @PostMapping("signin")
    public ResponseEntity<String> signin(@RequestBody SignInInput signInDto){

        String response;
        HttpStatus status;

        try{
            userService.signIn(signInDto);
            response = "Sign in successful";
            status = HttpStatus.CREATED;
        }catch (Exception e){
            response = "User not exist.... Sign up instead";
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<String>(response, status);
    }

    @PutMapping("{userEmail}/{token}")
    public String updateUser(@PathVariable String userEmail, @PathVariable String token, @RequestBody User user){

        if(authenticationService.authenticateUser(userEmail, token)){
            return userService.updateUser(user);
        }else{
            return "Signup first!!";
        }
    }
}

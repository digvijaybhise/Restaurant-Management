package com.geekster.Restaurant_Management_Service.service;

import com.geekster.Restaurant_Management_Service.dto.SignInInput;
import com.geekster.Restaurant_Management_Service.dto.SignUpInput;
import com.geekster.Restaurant_Management_Service.model.AuthenticationToken;
import com.geekster.Restaurant_Management_Service.model.User;
import com.geekster.Restaurant_Management_Service.repository.IAuthenticationRepository;
import com.geekster.Restaurant_Management_Service.repository.IUserRepository;
import jakarta.transaction.Transactional;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IAuthenticationRepository authenticationRepository;


    public void signUp(SignUpInput signUpDto) {
        // first check user present or not
        boolean checkUser = userRepository.existsByUserEmail(signUpDto.getUserEmail());

        if(checkUser){
            throw new IllegalStateException("Sign in instead");
        }

        //encryption
        String encryptedPassword = null;

        try {
            encryptedPassword = encypt(signUpDto.getUserPassword());
        }catch (Exception e){
            e.printStackTrace();
        }

        // save user
        User user = new User(signUpDto.getUserFirstName(), signUpDto.getUserLastName(),
                signUpDto.getUserPhoneNumber(), signUpDto.getUserEmail(), encryptedPassword);

        userRepository.save(user);
    }

    private String encypt(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(userPassword.getBytes());
        byte[] digest = md5.digest();

        String hash = DatatypeConverter.printHexBinary(digest);
        return hash;
    }

    public void signIn(SignInInput signInDto) {

        //check user present or not
        User user = userRepository.findByUserEmail(signInDto.getUserEmail());

        if (user == null){
            throw new IllegalStateException("Sign up first");
        }

        //encryption
        String encryptedPassword = null;

        try {
            encryptedPassword = encypt(signInDto.getUserPassword());
        }catch (Exception e){
            e.printStackTrace();
        }

        if(encryptedPassword.equals(user.getUserPassword())){
            AuthenticationToken token = new AuthenticationToken(user);
            authenticationRepository.save(token);
        }else{
            throw new IllegalStateException();
        }
    }

    @Transactional
    public String updateUser(User user) {
        userRepository.save(user);
        return "User updated Successfully!!!";
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

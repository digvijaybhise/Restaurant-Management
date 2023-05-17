package com.geekster.Restaurant_Management_Service.service;

import com.geekster.Restaurant_Management_Service.model.Admin;
import com.geekster.Restaurant_Management_Service.repository.IAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    IAdminRepository adminRepository;

    public void addAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    public boolean checkAdmin(String adminEmail) {
        return adminRepository.existsByAdminEmail(adminEmail);
    }
}

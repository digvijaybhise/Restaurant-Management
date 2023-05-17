package com.geekster.Restaurant_Management_Service.repository;

import com.geekster.Restaurant_Management_Service.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepository extends JpaRepository<Admin,Integer> {

    public boolean existsByAdminEmail(String adminEmail);
}

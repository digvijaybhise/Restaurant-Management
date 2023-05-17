package com.geekster.Restaurant_Management_Service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_Admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;

    @NotNull
    private String adminName;

    @Email(regexp = "[A-Za-z0-9]+@admin\\.com")
    private String adminEmail;

    @NotNull
    private String adminPassword;
}

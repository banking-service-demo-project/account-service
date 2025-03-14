package com.example.account.service.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @NotNull(message = "User ID cannot be null")
    private String userId;

    @NotNull(message = "Account type cannot be null")
    private String accountType;

    @Positive(message = "Balance must be positive")
    private Double balance;

    // Getters and Setters
}



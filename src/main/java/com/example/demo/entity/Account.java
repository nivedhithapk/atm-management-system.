package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Account {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;


    @NotBlank(message = "Account holder name is required")
    private String accountHolder;

    @NotBlank(message = "Account number is required")
    private String accountNumber;

    @PositiveOrZero(message = "Balance cannot be negative")
    private double balance;

        public Account() {
        }

        public Account(String accountHolder, String accountNumber, double balance) {
            this.accountHolder = accountHolder;
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        public Long getId() {
            return id;
        }

        public String getAccountHolder() {
            return accountHolder;
        }

        public void setAccountHolder(String accountHolder) {
            this.accountHolder = accountHolder;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }
    }


package com.example.demo.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long accountId;
    private String type;
    private double amount;
    private LocalDateTime transactionTime;

    public Transaction() {
    }

    public Transaction(Long accountId, String type, double amount) {
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
        this.transactionTime = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }
}

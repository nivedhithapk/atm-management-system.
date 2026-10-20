package com.example.demo.controller;
import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Transaction;
import com.example.demo.repository.TransactionRepository;
import java.util.List;
import java.util.Map;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/accounts")

public class AccountController {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public AccountController(
            AccountRepository accountRepository,
            TransactionRepository transactionRepository) {

        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    // Create a new account
    @PostMapping
    public Account createAccount(@Valid @RequestBody Account account) {
        return accountRepository.save(account);
    }


    // Get all accounts
    @GetMapping
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Get an account by ID
    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountRepository.findById(id).orElse(null);
    }


    @PostMapping("/{id}/deposit")
    public Account depositMoney(
            @PathVariable Long id,
            @RequestBody java.util.Map<String, Double> request) {

        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        double amount = request.get("amount");

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Deposit amount must be positive");
        }
        account.setBalance(account.getBalance() + amount);

        Account savedAccount = accountRepository.save(account);

        Transaction transaction =
                new Transaction(savedAccount.getId(), "DEPOSIT", amount);

        transactionRepository.save(transaction);

        return savedAccount;

    }

    // Withdraw money
    @PostMapping("/{id}/withdraw")
    public Account withdrawMoney(
            @PathVariable Long id,
            @RequestBody Map<String, Double> request) {

        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        Double amount = request.get("amount");

        if (amount == null || !Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException(
                    "Withdrawal amount must be positive");
        }

        if (amount > account.getBalance()) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        account.setBalance(account.getBalance() - amount);

        Account savedAccount = accountRepository.save(account);

        Transaction transaction =
                new Transaction(savedAccount.getId(), "WITHDRAWAL", amount);

        transactionRepository.save(transaction);

        return savedAccount;
    }
    @GetMapping("/{id}/transactions")
    public List<Transaction> getTransactions(@PathVariable Long id) {

        if (!accountRepository.existsById(id)) {
            throw new RuntimeException("Account not found");
        }

        return transactionRepository
                .findByAccountIdOrderByTransactionTimeDesc(id);
    }


}



package com.example.spring;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class bankAccountService {

    private final Map<Long, BankAccount> accounts = new HashMap<>();

    public BankAccount getAccount(Long accountId) {
        return accounts.get(accountId);
    }

    public String createAccount(Long accountId, String accountHolderName, double initialBalance) {
        if (accounts.containsKey(accountId)) {
            return "Account with this ID already exists!";
        }
        accounts.put(accountId, new BankAccount(accountHolderName, initialBalance));
        return "Account created successfully!";
    }

    public String deposit(Long accountId, double amount) {
        BankAccount account = accounts.get(accountId);
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
            return "Deposit successful!";
        }
        return "Account not found!";
    }

    public String withdraw(Long accountId, double amount) {
        BankAccount account = accounts.get(accountId);
        if (account != null) {
            if (account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                return "Withdrawal successful!";
            } else {
                return "Insufficient balance!";
            }
        }
        return "Account not found!";
    }
}

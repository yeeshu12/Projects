package com.example.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/bank")
public class bankAccountController {

    @Autowired
    private bankAccountService bankAccountService;

    @PostMapping("/create")
    public String createAccount(@RequestParam Long accountId,
                                @RequestParam String accountHolderName,
                                @RequestParam double initialBalance) {
        return bankAccountService.createAccount(accountId, accountHolderName, initialBalance);
    }

    @GetMapping("/account/{accountId}")
    public BankAccount getAccount(@PathVariable Long accountId) {
        return bankAccountService.getAccount(accountId);
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam Long accountId, @RequestParam double amount) {
        return bankAccountService.deposit(accountId, amount);
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam Long accountId, @RequestParam double amount) {
        return bankAccountService.withdraw(accountId, amount);
    }
}

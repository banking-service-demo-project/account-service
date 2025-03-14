package com.example.account.service.controller;

import com.example.account.service.entity.Account;
import com.example.account.service.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody @Valid Account account) {
        Account createdAccount = accountService.createAccount(account);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Collection<Account>> getAllAccount() {
        Collection<Account> accountList = accountService.getAllAccount();
        return new ResponseEntity<>(accountList, HttpStatus.CREATED);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccount(@PathVariable Long accountId) {
        Optional<Account> account = accountService.getAccount(accountId);
        return account.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long accountId, @RequestBody @Valid Account account) {
        Account updatedAccount = accountService.updateAccount(accountId, account);
        return updatedAccount != null ? ResponseEntity.ok(updatedAccount) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long accountId) {
        boolean deleted = accountService.deleteAccount(accountId);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<Account> getAccountByUserId(@PathVariable String userId) {
        Optional<Account> account = accountService.getAccountByUserId(userId);
        return account.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

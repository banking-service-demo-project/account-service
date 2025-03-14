package com.example.account.service.service.impl;

import com.example.account.service.entity.Account;

import com.example.account.service.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;

@Service
public class AccountServiceImpl {
    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Optional<Account> getAccount(Long accountId) {
        return Optional.ofNullable(accountRepository.findByAccountId(accountId));
    }

    public Collection<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    public Account updateAccount(Long accountId, Account account) {
        Account existingAccount = accountRepository.findByAccountId(accountId);
        if (existingAccount != null) {
            existingAccount.setUserId(account.getUserId());
            existingAccount.setAccountType(account.getAccountType());
            existingAccount.setBalance(account.getBalance());
            return accountRepository.save(existingAccount);
        }
        return null;
    }

    @Transactional
    public boolean deleteAccount(Long accountId) {
        Account account = accountRepository.findByAccountId(accountId);
        if (account != null) {
            accountRepository.delete(account);
            return true;
        }
        return false;
    }

    public Optional<Account> getAccountByUserId(String userId) {
        return Optional.ofNullable(accountRepository.findByUserId(userId));
    }
}

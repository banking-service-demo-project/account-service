package com.example.account.service.repository;

import com.example.account.service.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByAccountId(Long accountId);

    Account findByUserId(String userId);
}


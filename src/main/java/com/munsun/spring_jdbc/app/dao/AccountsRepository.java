package com.munsun.spring_jdbc.app.dao;

import com.munsun.spring_jdbc.app.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findByLogin(String login);
}

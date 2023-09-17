package com.munsun.spring_jdbc.app.config;

import com.munsun.spring_jdbc.app.dao.AccountsRepository;
import com.munsun.spring_jdbc.app.model.Account;
import com.munsun.spring_jdbc.app.model.Status;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private AccountsRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = repository.findByLogin(username).orElseThrow(()->
            new UsernameNotFoundException("user not found")
        );
        var user =  User.builder()
                    .username(account.getLogin())
                    .password(account.getPassword())
                    .roles(account.getRole().name())
                    .disabled(!account.getStatus().name().equals(Status.ACTIVE.name()))
                    .accountExpired(!account.getStatus().name().equals(Status.ACTIVE.name()))
                    .accountLocked(!account.getStatus().name().equals(Status.ACTIVE.name()))
                    .credentialsExpired(!account.getStatus().name().equals(Status.ACTIVE.name()))
                .build();
        return user;
    }
}

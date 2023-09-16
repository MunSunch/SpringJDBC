package com.munsun.spring_jdbc.app.config;

import com.munsun.spring_jdbc.app.dao.AccountsRepository;
import com.munsun.spring_jdbc.app.model.Account;
import lombok.AllArgsConstructor;
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
        return MyUserDetail.account2UserDetail(account);
    }
}

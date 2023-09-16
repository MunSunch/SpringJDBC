package com.munsun.spring_jdbc.app.config;

import com.munsun.spring_jdbc.app.model.Account;
import com.munsun.spring_jdbc.app.model.Status;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Data
public class MyUserDetail implements UserDetails {
    private String login;
    private String password;
    private List<SimpleGrantedAuthority> authorities;
    private String role;
    private boolean status;

    public static UserDetails account2UserDetail(Account account) {
        var user = User.builder()
                    .username(account.getLogin())
                    .password(account.getPassword())
                    .authorities(account.getRole().getGrants())
                    .disabled(!account.getStatus().name().equals(Status.ACTIVE.name()))
                    .accountExpired(!account.getStatus().name().equals(Status.ACTIVE.name()))
                    .accountLocked(!account.getStatus().name().equals(Status.ACTIVE.name()))
                    .credentialsExpired(!account.getStatus().name().equals(Status.ACTIVE.name()))
                .build();
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return status;
    }

    @Override
    public boolean isAccountNonLocked() {
        return status;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return status;
    }

    @Override
    public boolean isEnabled() {
        return status;
    }
}

package com.munsun.spring_jdbc.app.config;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public enum Roles {
    ADMIN(List.of("read", "write")),
    USER(List.of("read"));

    private List<String> authorities;

    Roles(List<String> authorities) {
        this.authorities = authorities;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public List<SimpleGrantedAuthority> getGrants() {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}

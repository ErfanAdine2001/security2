package com.example.spring_security2.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomeUserDetail implements UserDetails {

    private final String username;
    private final String password;
    private final Boolean isEnabled;
    private final Collection<? extends GrantedAuthority> authorities;

    public CustomeUserDetail(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.isEnabled = user.getIsEnabled();
        this.authorities = user.getAuthorities();
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
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}

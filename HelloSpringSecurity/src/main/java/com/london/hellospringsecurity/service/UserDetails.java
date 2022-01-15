package com.london.hellospringsecurity.service;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

public interface UserDetails extends Serializable {
    String getUsername();
    String getPassword();                 //  These methods return the user credentials.
    Collection<? extends GrantedAuthority> getAuthorities();  // Returns the actions that the app allows the user to do as a collection of GrantedAuthority instances
    boolean isAccountNonExpired();      //  These four methods enable or disable the account for different reasons.
    boolean isAccountNonLocked();
    boolean isCredentialsNonExpired();
    boolean isEnabled();
}
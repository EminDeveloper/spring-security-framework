package com.london.hellospringsecurity.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class InMemoryUserDetailsService implements UserDetailsService {
    
    private final List<UserDetails> users;   //  UserDetailsService manages the list of users in-memory

    public InMemoryUserDetailsService(List<UserDetails> users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        return users.stream()
                .filter(     //  From the list of users, filters the one that has the requested username
                        u -> u.getUsername().equals(username)
                )
                .findFirst()      //  If there is such a user, returns it
                .orElseThrow(    //  If a user with this username does not exist, throws an exception
                        () -> new UsernameNotFoundException("User not found")
                );
    }
}
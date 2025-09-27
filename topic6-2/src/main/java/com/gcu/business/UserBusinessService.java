package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gcu.data.UsersDataService;
import com.gcu.data.entity.UserEntity;

@Service
public class UserBusinessService implements UserDetailsService
{
    private UsersDataService service;

    @Autowired
    public UserBusinessService(UsersDataService service) {
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
    {
        UserEntity user = service.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        
        System.out.println("Found user: " + user.getUsername());
        System.out.println("Stored hash: " + user.getPassword());

        return User.withUsername(user.getUsername())
                   .password(user.getPassword())
                   .roles("USER")
                   .build();
    }
}

package com.api.gateway.service.impl;

import com.api.gateway.entity.Role;
import com.api.gateway.entity.User;
import com.api.gateway.exceptions.CustomException;
import com.api.gateway.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if (user == null || user.getRoles() == null || user.getRoles().isEmpty()) {
            throw new CustomException("Invalid username or password.", HttpStatus.UNAUTHORIZED);
        }
        String[] authorities = new String[user.getRoles().size()];
        int count = 0;
        for (Role role : user.getRoles()) {
            //NOTE: normally we dont need to add "ROLE_" prefix. Spring does automatically for us.
            //Since we are using custom token using JWT we should add ROLE_ prefix
            authorities[count] = "ROLE_" + role.getRole();
            count++;
        }
        CustomUserDetails userDetails = new CustomUserDetails(user.getUsername(), user.getPassword(), user.getActive(),
                user.isLoacked(), user.isExpired(), user.isEnabled(), authorities);
        return userDetails;
    }

}



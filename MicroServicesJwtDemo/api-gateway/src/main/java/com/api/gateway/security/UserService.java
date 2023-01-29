package com.api.gateway.security;

import com.api.gateway.dto.MongoUserDetails;
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
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null || user.getRole() == null || user.getRole().isEmpty()) {
            throw new CustomException("Invalid username or password.", HttpStatus.UNAUTHORIZED);
        }
        String[] authorities = new String[user.getRole().size()];
        int count = 0;
        for (Role role : user.getRole()) {
            authorities[count] = "ROLE_" + role.getRole();
            count++;
        }
        MongoUserDetails userDetails = new MongoUserDetails(user.getEmail(), user.getPassword(), user.getActive(),
                user.isLocked(), user.isExpired(), user.isEnabled(), authorities);
        return userDetails;
    }


}
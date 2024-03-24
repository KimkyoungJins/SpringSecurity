package com.example.spring_security.service;

import com.example.spring_security.domain.UserDomain;
import com.example.spring_security.dto.CustomUserDetails;
import com.example.spring_security.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Override  // override가 되는 이유는?
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDomain userData = userRepository.findByUsername(username);

        if (userData != null) {

            return new CustomUserDetails(userData);
        }
        return null;
    }
}

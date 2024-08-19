package com.xuanphi.usermanagement.service.impl;

import com.xuanphi.usermanagement.model.entity.CustomUserDetails;
import com.xuanphi.usermanagement.model.entity.Role;
import com.xuanphi.usermanagement.model.entity.User;
import com.xuanphi.usermanagement.repository.UserRepository;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElse(null);

        if (user != null && user.isActive()) {
            return new CustomUserDetails(user);
        }else{
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }
}

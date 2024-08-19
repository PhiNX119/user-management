package com.xuanphi.usermanagement.service.impl;

import com.xuanphi.usermanagement.model.dto.UserDto;
import com.xuanphi.usermanagement.model.entity.CustomUserDetails;
import com.xuanphi.usermanagement.model.entity.Role;
import com.xuanphi.usermanagement.model.entity.User;
import com.xuanphi.usermanagement.repository.RoleRepository;
import com.xuanphi.usermanagement.repository.UserRepository;
import com.xuanphi.usermanagement.service.UserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public CustomUserDetails getUserDetail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            return userDetails;
        }
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        return user;
    }

    @Transactional
    @Override
    public void saveNewUser(UserDto userDto) {
        User user = new User();
        user.loadFromDto(userDto);

        // Encrypt the password
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        // Set roles
        List<Role> roleList = userDto.getRoles().stream()
                .map(roleDto -> {
                    Role role = roleRepository.findByName(roleDto.getName())
                            .orElseGet(() -> roleRepository.save(new Role(null, roleDto.getName(), null)));
                    return role;
                })
                .collect(Collectors.toList());

        user.setRoles(roleList);

        userRepository.save(user);
    }

    @Override
    public List<UserDto> getUserList() {
        return userRepository.findAll().stream()
                .map(user -> {
                    UserDto userDto = new UserDto();
                    userDto.loadFromEntity(user);
                    return userDto;
                })
                .collect(Collectors.toList());
    }
}

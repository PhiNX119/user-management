package com.xuanphi.usermanagement.config;

import com.xuanphi.usermanagement.model.dto.RoleDto;
import com.xuanphi.usermanagement.model.dto.UserDto;
import com.xuanphi.usermanagement.model.entity.Role;
import com.xuanphi.usermanagement.model.entity.User;
import com.xuanphi.usermanagement.service.RoleService;
import com.xuanphi.usermanagement.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DataInitializer {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public DataInitializer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void init() {
        try {
            createRoles();
            createUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createRoles() {
        List<Role> roles = Arrays.asList(
                new Role(null, "ROLE_ADMIN", null),
                new Role(null, "ROLE_PREMIUM_USER", null),
                new Role(null, "ROLE_COMMON_USER", null)
        );

        for (Role role : roles) {
            if (roleService.getRoleByName(role.getName()) == null) {
                roleService.addNewRole(role);
            }
        }
    }

    private void createUser(List<String> roleNames, String username, String password) {
        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        userDto.setPassword(password);
        userDto.setActive(true);

        List<RoleDto> roleDtos = roleNames.stream()
                .map(roleName -> {
                    Role role = roleService.getRoleByName(roleName);
                    if (role != null) {
                        RoleDto roleDto = new RoleDto();
                        roleDto.loadFromEntity(role);
                        return roleDto;
                    }
                    return null;
                })
                .filter(roleDto -> roleDto != null)
                .collect(Collectors.toList());

        userDto.setRoles(roleDtos);

        if (userService.getUserByUsername(username) == null) {
            userService.saveNewUser(userDto);
        }
    }

    private void createUsers() {
        createUser(Arrays.asList("ROLE_ADMIN", "ROLE_PREMIUM_USER", "ROLE_COMMON_USER"), "admin", "123");
        createUser(Arrays.asList("ROLE_PREMIUM_USER", "ROLE_COMMON_USER"), "premium", "123");
        createUser(Arrays.asList("ROLE_COMMON_USER"), "common", "123");
    }
}
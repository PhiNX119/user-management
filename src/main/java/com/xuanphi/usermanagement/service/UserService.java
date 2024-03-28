package com.xuanphi.usermanagement.service;


import com.xuanphi.usermanagement.modal.dto.UserDto;
import com.xuanphi.usermanagement.modal.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByUsername(String username);

    List<UserDto> findAllUsers();
}

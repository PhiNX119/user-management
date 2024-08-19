package com.xuanphi.usermanagement.service;


import com.xuanphi.usermanagement.model.dto.UserDto;
import com.xuanphi.usermanagement.model.entity.CustomUserDetails;
import com.xuanphi.usermanagement.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    CustomUserDetails getUserDetail();

    void saveNewUser(UserDto userDto);

    User getUserByUsername(String username);

    List<UserDto> getUserList();
}

package com.xuanphi.usermanagement.controller;

import com.xuanphi.usermanagement.model.dto.UserDto;
import com.xuanphi.usermanagement.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {
    private UserService userService;

    public AdminController(UserService userService){
        this.userService = userService;
    }

    // handler method to handle list of users
    @GetMapping("admin/user-list")
    public String users(Model model) {
        List<UserDto> userList = userService.getUserList();
        model.addAttribute("userList", userList);
        return "user/list";
    }
}

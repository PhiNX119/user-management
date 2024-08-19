package com.xuanphi.usermanagement.controller;

import com.xuanphi.usermanagement.model.dto.UserDto;
import com.xuanphi.usermanagement.model.entity.User;
import com.xuanphi.usermanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author phinx
 * @description controller class contain authorization function
 */
@Controller
public class AuthController {
    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    /**
     * @author phinx
     * @description redirect to home page
     */
    @GetMapping("/index")
    public String home() {
        return "index";
    }

    /**
     * @author phinx
     * @description redirect to login page
     */
    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    /**
     * @author phinx
     * @description redirect to register page
     */
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        // create model object to store form data
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "user/register";
    }

    /**
     * @author phinx
     * @description handler method to handle user registration form submit request
     */
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model) {
        User existingUser = userService.getUserByUsername(userDto.getUsername());

        if (existingUser != null) {
            if (existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
                result.rejectValue("email", null,
                        "There is already an account registered with the same email");
            }
            if (existingUser.getUsername() != null && !existingUser.getUsername().isEmpty()) {
                result.rejectValue("username", null,
                        "There is already an account registered with the same username");
            }
        }

        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "user/register";
        }

        userService.saveNewUser(userDto);
        return "redirect:/register?success";
    }


}

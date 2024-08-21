package com.xuanphi.usermanagement.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestRestController {
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/common")
    @PreAuthorize("hasRole('COMMON_USER') or hasRole('PREMIUM_USER') or hasRole('ADMIN')")
    public String userAccess() {
        return "Common user Content.";
    }

    @GetMapping("/premium")
    @PreAuthorize("hasRole('PREMIUM_USER')")
    public String moderatorAccess() {
        return "Premium user Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}
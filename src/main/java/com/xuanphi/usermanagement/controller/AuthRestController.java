package com.xuanphi.usermanagement.controller;

import com.xuanphi.usermanagement.model.payload.request.AuthenticationRequest;
import com.xuanphi.usermanagement.model.payload.request.RegistrationRequest;
import com.xuanphi.usermanagement.model.payload.response.AuthenticationResponse;
import com.xuanphi.usermanagement.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication")
public class AuthRestController {

    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> register(
            @RequestBody @Valid RegistrationRequest registrationRequest
    ) throws MessagingException {
        userService.registerUser(registrationRequest);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/activate-account")
    public void confirm(@RequestParam String token) throws MessagingException {
        userService.activateAccount(token);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody @Valid AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(userService.authenticateUser(authenticationRequest));
    }
}
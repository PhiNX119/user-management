package com.xuanphi.usermanagement.service;


import com.xuanphi.usermanagement.model.payload.request.AuthenticationRequest;
import com.xuanphi.usermanagement.model.payload.request.RegistrationRequest;
import com.xuanphi.usermanagement.model.payload.response.AuthenticationResponse;
import com.xuanphi.usermanagement.model.entity.User;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User getUserByUsername(String username);

    void registerUser(RegistrationRequest registrationRequest) throws MessagingException;

    void activateAccount(String token) throws MessagingException;

    AuthenticationResponse authenticateUser(AuthenticationRequest authenticationRequest);
}

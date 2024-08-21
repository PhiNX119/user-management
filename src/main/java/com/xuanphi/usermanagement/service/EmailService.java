package com.xuanphi.usermanagement.service;

import com.xuanphi.usermanagement.model.entity.EmailTemplateName;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    void sendEmail(String to, String username, EmailTemplateName emailTemplateName, String confirmationUrl, String activationCode, String subject) throws MessagingException;
}

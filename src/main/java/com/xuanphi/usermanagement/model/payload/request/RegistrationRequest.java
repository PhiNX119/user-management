package com.xuanphi.usermanagement.model.payload.request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.sql.Date;

@Data
@Builder
public class RegistrationRequest {

    @NotEmpty(message = "Username is mandatory")
    @NotBlank(message = "Username is mandatory")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;

    @NotEmpty(message = "Password is mandatory")
    @NotBlank(message = "Password is mandatory")
    @Size(min = 3, message = "Password must be at least 3 characters")
    private String password;

    @NotEmpty(message = " First name is mandatory")
    @NotBlank(message = " First name is mandatory")
    private String firstName;

    @NotEmpty(message = "Last name is mandatory")
    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @Email(message = "Email is not formatted")
    @NotEmpty(message = "Email is mandatory")
    @NotBlank(message = "Email is mandatory")
    private String email;
}

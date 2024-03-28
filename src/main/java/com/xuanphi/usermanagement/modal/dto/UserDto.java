package com.xuanphi.usermanagement.modal.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    @NotBlank(message = "Mandatory information.")
    private String firstName;

    @NotBlank(message = "Mandatory information.")
    private String lastName;

    @NotBlank(message = "Mandatory information.")
    @Email(message = "Invalid Email.")
    private String email;

    @NotBlank(message = "Mandatory information.")
    @Size(min = 1, message = "Minimum length is 1.")
    private String username;

    @NotBlank(message = "Mandatory information.")
//    @Size(min = 8, message = "Minimum length is 8.")
//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",
//            message = "Minimum eight characters, at least one letter, one number and one special character.")
    private String password;
}

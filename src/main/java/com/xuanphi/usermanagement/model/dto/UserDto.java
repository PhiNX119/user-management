package com.xuanphi.usermanagement.model.dto;

import com.xuanphi.usermanagement.model.entity.Role;
import com.xuanphi.usermanagement.model.entity.User;
import jakarta.validation.constraints.*;
import lombok.*;

import java.sql.Date;
import java.util.Collection;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer id;

    @NotBlank(message = "Username is mandatory")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;

    @NotBlank(message = "Password is mandatory")
    //@Size(min = 8, message = "Password must be at least 8 characters")
    private String password;

    @NotBlank(message = " First name is mandatory")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @NotNull(message = "Date of birth is mandatory")
    @Past(message = "Date of birth must be in the past")
    private Date dateOfBirth;

    private boolean gender;

    @NotBlank(message = "Address is mandatory")
    private String address;

    @NotBlank()
    private String email;

    @NotBlank(message = "Phone number is mandatory")
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number is invalid")
    private String phoneNumber;

    private boolean isActive;

    private Collection<RoleDto> roles; // Assuming RoleDto has similar conversion methods

    public void loadFromEntity(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.dateOfBirth = user.getDateOfBirth();
        this.gender = user.isGender();
        this.address = user.getAddress();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
        this.isActive = user.isEnabled();
        this.roles = user.getRoles().stream()
                .map(role -> {
                    RoleDto roleDto = new RoleDto();
                    roleDto.loadFromEntity(role);
                    return roleDto;
                })
                .collect(Collectors.toList());
    }
}

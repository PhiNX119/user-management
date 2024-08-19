package com.xuanphi.usermanagement.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.xuanphi.usermanagement.model.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    @Nationalized
    private String username;

    @Column(nullable = false)
    @Nationalized
    private String password;

    @Column
    @Nationalized
    private String firstName;

    @Column
    @Nationalized
    private String lastName;

    @Column
    private Date dateOfBirth;

    @Column
    private boolean gender;

    @Column
    @Nationalized
    private String address;

    @Column
    private String email;

    @Column
    private String phoneNumber;

    @Column(nullable = false)
    private boolean isActive;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Collection<Role> roles;

    public void loadFromDto(UserDto userDto) {
        this.id = userDto.getId();
        this.username = userDto.getUsername();
        this.password = userDto.getPassword();
        this.firstName = userDto.getFirstName();
        this.lastName = userDto.getLastName();
        this.dateOfBirth = userDto.getDateOfBirth();
        this.gender = userDto.isGender();
        this.address = userDto.getAddress();
        this.email = userDto.getEmail();
        this.phoneNumber = userDto.getPhoneNumber();
        this.isActive = userDto.isActive();
        this.roles = userDto.getRoles().stream()
                .map(roleDto -> {
                    Role role = new Role();
                    role.loadFromDto(roleDto);
                    return role;
                })
                .collect(Collectors.toList());
    }
}
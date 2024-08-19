package com.xuanphi.usermanagement.model.dto;

import com.xuanphi.usermanagement.model.entity.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {
    private Integer id;

    private String name;

    public void loadFromEntity(Role role) {
        this.id = role.getId();
        this.name = role.getName();
    }
}

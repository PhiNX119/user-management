package com.xuanphi.usermanagement.repository;

import com.xuanphi.usermanagement.modal.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}

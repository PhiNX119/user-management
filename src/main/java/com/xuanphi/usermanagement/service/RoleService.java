package com.xuanphi.usermanagement.service;

import com.xuanphi.usermanagement.model.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    Role getRoleByName(String name);
    List<Role> getRoleList();
    void addNewRole(Role role);
}

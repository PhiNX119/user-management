package com.xuanphi.usermanagement.service.impl;

import com.xuanphi.usermanagement.model.entity.Role;
import com.xuanphi.usermanagement.repository.RoleRepository;
import com.xuanphi.usermanagement.service.RoleService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleByName(String name) {
        Role role = roleRepository.findByName(name).orElse(null);
        return role;
    }

    @Override
    public List<Role> getRoleList() {
        return roleRepository.findAll();
    }

    @Override
    public void addNewRole(Role role) {
        roleRepository.save(role);
    }
}

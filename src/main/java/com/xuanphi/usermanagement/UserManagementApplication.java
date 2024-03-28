package com.xuanphi.usermanagement;

import com.xuanphi.usermanagement.modal.entity.Role;
import com.xuanphi.usermanagement.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class UserManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserManagementApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(RoleRepository roleRepository) {
        return runner -> {
            Role role1 = new Role();
            role1.setName("ROLE_ADMIN");
            roleRepository.save(role1);

            Role role2 = new Role();
            role2.setName("ROLE_STUDENT");
            roleRepository.save(role2);

            Role role3 = new Role();
            role3.setName("ROLE_TEACHER");
            roleRepository.save(role3);
        };
    }
}

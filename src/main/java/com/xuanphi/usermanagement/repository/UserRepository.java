package com.xuanphi.usermanagement.repository;

import com.xuanphi.usermanagement.modal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}

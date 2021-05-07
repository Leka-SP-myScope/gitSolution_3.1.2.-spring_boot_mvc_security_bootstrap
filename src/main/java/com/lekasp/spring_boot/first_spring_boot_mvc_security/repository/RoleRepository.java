package com.lekasp.spring_boot.first_spring_boot_mvc_security.repository;

import com.lekasp.spring_boot.first_spring_boot_mvc_security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
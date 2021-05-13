package com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.repository;

import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
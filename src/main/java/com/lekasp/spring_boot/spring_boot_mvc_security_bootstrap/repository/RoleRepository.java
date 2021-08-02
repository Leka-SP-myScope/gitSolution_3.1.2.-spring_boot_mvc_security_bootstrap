package com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.repository;

import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT r FROM Role r WHERE r.role = :roleName")
    Role findByName(@Param("roleName") String name);
}
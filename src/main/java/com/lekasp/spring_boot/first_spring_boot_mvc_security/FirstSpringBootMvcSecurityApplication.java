package com.lekasp.spring_boot.first_spring_boot_mvc_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.lekasp.spring_boot.first_spring_boot_mvc_security.repository")
@EntityScan("com.lekasp.spring_boot.first_spring_boot_mvc_security.model")
@SpringBootApplication
public class FirstSpringBootMvcSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstSpringBootMvcSecurityApplication.class, args);
    }

}

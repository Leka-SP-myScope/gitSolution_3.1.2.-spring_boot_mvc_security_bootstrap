package com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap;

import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootMvcSecurityBootstrapApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMvcSecurityBootstrapApplication.class, args);
    }
}

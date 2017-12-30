package com.spring.boot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.spring.boot.controller"})
@EnableJpaRepositories( {"com.spring.boot.repository"})
@EntityScan("com.spring.boot.entity")
public class UserApplication {
    public static void main(final String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}

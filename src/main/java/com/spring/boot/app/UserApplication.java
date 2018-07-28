package com.spring.boot.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.spring.boot.controller"})
@EnableJpaRepositories( {"com.spring.boot.repository"})
@EntityScan("com.spring.boot.entity")
public class UserApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserApplication.class);

    public static void main(final String[] args) {
        LOGGER.info("Starting spring-boot-embedded-tomcat-and-database app");

        SpringApplication.run(UserApplication.class, args);
    }
}

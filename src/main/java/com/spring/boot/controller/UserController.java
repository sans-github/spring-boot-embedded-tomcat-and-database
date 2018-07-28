package com.spring.boot.controller;

import com.spring.boot.entity.User;
import com.spring.boot.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping(value = "/users")
    public @ResponseBody
    User addUser(@RequestParam final String name, @RequestParam final String email) {
        logger.info("Add user request received. name={}, email={}", name, email);

        final User user = new User();
        user.setName(name);
        user.setEmail(email);

        logger.info("Saving user. name={}, email={}", name, email);
        return userRepository.save(user);
    }

    @GetMapping(value = "/users")
    @ResponseBody
    public Iterable<User> getAllUsers() {
        logger.info("Find All request.");

        final Iterable<User> users = userRepository.findAll();

        logger.info("Returning users. count={}.", numberOfUsers(users));
        return users;
    }

    @GetMapping(value = "/users/{user-id}")
    @ResponseBody
    public Optional<User> getUser(@PathVariable("user-id") final int userId) {
        logger.info("Find user with id={}.", userId);

        final Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            logger.info("User found");
        } else {
            logger.info("User not found");
        }

        return optionalUser;
    }

    private int numberOfUsers(final Iterable<User> users) {
        int length = 0;
        for (final User user : users) {
            ++length;
        }
        return length;
    }
}

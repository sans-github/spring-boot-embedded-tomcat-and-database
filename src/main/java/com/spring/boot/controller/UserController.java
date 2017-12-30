package com.spring.boot.controller;

import com.spring.boot.entity.User;
import com.spring.boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/users")
    public @ResponseBody
    User addNewUser(@RequestParam final String name, @RequestParam final String email) {

        final User user = new User();
        user.setName(name);
        user.setEmail(email);

        return userRepository.save(user);
    }

    @GetMapping(value = "/users")
    @ResponseBody
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}

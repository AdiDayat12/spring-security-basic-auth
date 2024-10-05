package com.nseva.basic_auth.controller;

import com.nseva.basic_auth.models.entities.User;
import com.nseva.basic_auth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register (@RequestBody User user) {
        System.out.println("Received registration request for user: " + user.getEmail());
        return userService.register(user);
    }

    @GetMapping
    public Iterable<User> getAll () {
        return userService.findAll();
    }
}

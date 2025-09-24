package com.ShareBite.ShareBite.controller;

import com.ShareBite.ShareBite.Entity.User;
import com.ShareBite.ShareBite.repositeries.UserRepository;
import com.ShareBite.ShareBite.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServices userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public void signup(@RequestBody User user){
        userService.signup(user);
    }
}

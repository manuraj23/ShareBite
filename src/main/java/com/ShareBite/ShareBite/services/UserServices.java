package com.ShareBite.ShareBite.services;

import com.ShareBite.ShareBite.Entity.User;
import com.ShareBite.ShareBite.repositeries.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServices {

    @Autowired
    public UserRepository userRepository;

    public void signup(User user) {
        userRepository.save(user);
    }
}

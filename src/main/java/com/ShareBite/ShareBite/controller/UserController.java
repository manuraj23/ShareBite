package com.ShareBite.ShareBite.controller;

import com.ShareBite.ShareBite.Entity.Food;
import com.ShareBite.ShareBite.Entity.User;
import com.ShareBite.ShareBite.repositeries.UserRepository;
import com.ShareBite.ShareBite.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServices userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/healthCheck")
    public String healthCheck() {
        return "I am alive! from User Controller";
    }

    @PostMapping("/addFood")
    public ResponseEntity<?> addFood(@RequestBody Food food) {
        return userService.addFood(food);
    }

    @GetMapping("/viewAvailableFood")
    public ResponseEntity<?> viewAvailableFood() {
        return userService.viewAvailableFood();
    }

    @PostMapping("/buyFood")
    public ResponseEntity<?> buyFood(@RequestBody Food food) {
        return userService.buyFood();
    }

//    @Getmapping("/ViewAllFood")
//    public ResponseEntity<?>ViewAllFood(){
//        List<Food>all=foodRepository.findAll();
//        if(all!=null && !all.isEmpty()){
//            return new ResponseEntity<>(all,HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }


}

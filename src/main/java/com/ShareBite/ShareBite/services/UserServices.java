package com.ShareBite.ShareBite.services;

import com.ShareBite.ShareBite.Entity.Food;
import com.ShareBite.ShareBite.Entity.User;
import com.ShareBite.ShareBite.repositeries.FoodRepository;
import com.ShareBite.ShareBite.repositeries.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class UserServices {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    private FoodRepository foodRepository;

    private static final PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
    public void saveNewUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(List.of("USER"));
        userRepository.save(user);
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public void saveUser(User user){
        userRepository.save(user);

    }

    public ResponseEntity<?> addFood(Food food) {
        try {
            // set the posted date/time automatically
            Date now = new Date();
            food.setPostedBy(now);

            if (food.getExpiryDate() == null) {
                // 6 hours in milliseconds = 6 * 60 * 60 * 1000
                long sixHoursLater = now.getTime() + (6 * 60 * 60 * 1000);
                food.setExpiryDate(new Date(sixHoursLater));
            }

            // save to MongoDB
            foodRepository.save(food);

            return ResponseEntity.ok("Food item added successfully!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error adding food: " + e.getMessage());
        }
    }

    public ResponseEntity<?> viewAvailableFood() {
        try {
            List<Food> allFood = foodRepository.findAll();
            if (allFood.isEmpty()) {
                return ResponseEntity.status(404).body("No food available currently.");
            }
            return ResponseEntity.ok(allFood);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error fetching food list: " + e.getMessage());
        }
    }


    public ResponseEntity<?> buyFood() {
        return null;
    }
}

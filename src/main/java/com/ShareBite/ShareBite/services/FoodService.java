package com.ShareBite.ShareBite.services;


import com.ShareBite.ShareBite.Entity.Food;
import com.ShareBite.ShareBite.repositeries.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public ResponseEntity<?> addFood(Food food) {
        try {
            foodRepository.save(food);
            return ResponseEntity.ok("Food item added successfully!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error adding food: " + e.getMessage());
        }
    }
}

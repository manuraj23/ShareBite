package com.ShareBite.ShareBite.repositeries;
import com.ShareBite.ShareBite.Entity.Food;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodRepository extends MongoRepository<Food, ObjectId> {
}
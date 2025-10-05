package com.ShareBite.ShareBite.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "FoodList")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    @Id
    private ObjectId id;

    @NonNull
    private String foodName;
    private int servings;
    private double price;
    private String description;
    private String category;
    private String imageUrl;
    private Date postedOn = new Date();
    private Date bestBefore=new Date();
    private boolean isAvailable=true;
    private boolean isSold=false;
    private String postedBy;
    private String phoneNumber;
    private String address;
    private String latitude;
    private String longitude;
}

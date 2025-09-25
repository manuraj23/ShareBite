package com.ShareBite.ShareBite.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FoodList")
@Data
@NoArgsConstructor
public class Buy {
    private String OrderType;
    private String FoodName;
    private String Quantity;
    private String Price;
    private String Address;
    private String PhoneNumber;
}

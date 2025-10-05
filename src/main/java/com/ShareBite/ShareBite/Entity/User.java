package com.ShareBite.ShareBite.Entity;

import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private ObjectId id;

    @Indexed(unique = true)
    @NonNull
    private String username;
    @NonNull
    private String password;

    @NonNull
    private String name;

    private String email;

    private List<String> roles;  //Admin , User

    private String userType; // Individual, Restaurant, NGO

//    @DBRef
//    private List<Food> buy=new ArrayList<>();

    @DBRef
    private List<Food> sales=new ArrayList<>();

}
package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.util.PathConstants;
import com.example.model.User;
import com.example.service.UserService;

import java.util.List;

@RestController
@CrossOrigin(origins = PathConstants.CORS_PATH) // Enable CORS for this controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(PathConstants.GET_USERS_PATH)
    public List<User> getUsers() {
        return userService.getAllUsers();
    }


    // Update user data
    @PostMapping(PathConstants.UPDATE_USERS_PATH)
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        try {
            User updatedUser = userService.updateUser(user);
            if (updatedUser != null) {
                return ResponseEntity.ok(updatedUser); // Return the updated user
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // If update fails
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    // Insert user data
    @PostMapping(PathConstants.INSERT_USERS_PATH)
    public ResponseEntity<User> insertUser(@RequestBody User user) {
        try {
            User insertedUser = userService.insertUser(user);
            if (insertedUser != null) {
                return ResponseEntity.ok(insertedUser); // Return the updated user
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // If update fails
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}

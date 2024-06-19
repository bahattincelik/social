package com.example.celikProjekt.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.celikProjekt.entities.User;
import com.example.celikProjekt.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {
    
    private final UserServices userService;
    
    public UserController(UserServices userRepository) {
        this.userService = userRepository;
    }
    
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @PostMapping
    public User createUser(@RequestBody User newUser) {
        return userService.saveOneUser(newUser);
    }
    
    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId) {
      return userService.getOneUser(userId);
    }
    
    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {
      return userService.updateOneUser(userId, newUser);
    }
    
    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId) {
       userService.deleteByID(userId);
    }
}

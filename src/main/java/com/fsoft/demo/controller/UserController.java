package com.fsoft.demo.controller;

import com.fsoft.demo.dto.UserDTO;
import com.fsoft.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserDTO> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public UserDTO getUser(@PathVariable(value = "id") Long id){
        return userService.findById(id);
    }

    @PostMapping("/users")
    public UserDTO createUser(@RequestBody UserDTO newUser){
        return userService.save(newUser);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserDTO> changePassword(@PathVariable(value = "id") Long id, @RequestBody String newPassword){
        UserDTO user = userService.changePassword(id, newPassword);
        return ResponseEntity.ok(user);
    }
}

package com.example.crudcarritocompra.controllers;

import com.example.crudcarritocompra.services.UserService;
import com.example.crudcarritocompra.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody String userName,String name){
        User newUser = userService.createUser(userName,name);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
    //TODO
}

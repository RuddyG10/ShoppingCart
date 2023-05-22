package com.example.crudcarritocompra.controllers;

import com.example.crudcarritocompra.Repository.UserRepository;
import com.example.crudcarritocompra.user.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void createAdmin(){

        //Verifica si ya se creo el usuario admin
        if (!userRepository.existsByUserName("admin")){
            User admin = new User();
            admin.setUserName("admin");
            admin.setPassword("admin");
            userRepository.save(admin);
        }
    }
}

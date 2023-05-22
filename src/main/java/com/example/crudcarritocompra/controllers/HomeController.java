package com.example.crudcarritocompra.controllers;

import com.example.crudcarritocompra.carrito.Product;
import com.example.crudcarritocompra.services.ProductService;
import com.example.crudcarritocompra.services.UserService;
import com.example.crudcarritocompra.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String listProducts(Model model){
        List<Product> products = productService.listProducts();
        model.addAttribute("products",products);
        return "index";
    }

    //login
    @GetMapping("/login-adm")
    public String login(){
        return "login";
    }

    @PostMapping("/login-adm")
    public String loginProcess(@RequestParam("username") String userName,
                               @RequestParam("password") String password,
                               Model model){
        Optional<User> auxUser = userService.findUserByusername(userName);
        if(auxUser.isPresent()){
            User user = auxUser.get();
            if (user.getPassword().equals(password)){
                return "redirect:/products/";
            }
        }
        model.addAttribute("error","Credenciales invalidas");
        return "redirect:/login-adm";
    }

}

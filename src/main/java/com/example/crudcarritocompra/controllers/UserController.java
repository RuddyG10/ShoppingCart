package com.example.crudcarritocompra.controllers;

import com.example.crudcarritocompra.carrito.Product;
import com.example.crudcarritocompra.services.CarritoCompraService;
import com.example.crudcarritocompra.services.ProductService;
import com.example.crudcarritocompra.services.UserService;
import com.example.crudcarritocompra.user.User;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
@RestController
@RequestMapping("/homePage")
public class UserController {

    //Parameters
    private final ProductService productService = new ProductService();
    private final CarritoCompraService carritoCompraService = new CarritoCompraService();
    private final UserService userService = new UserService();
    //Post constructs
    @PostConstruct
    public void addProducts(){
        productService.crearProducto("product1", BigDecimal.valueOf(40.00));
        productService.crearProducto("product2",BigDecimal.valueOf(50.00));
    }
    @PostConstruct
    public void addAdmin(){
        userService.createUser("admin","Admin");
    }

    //Home Page
    @GetMapping("/init")
    public String home(){
        return "home";
    }
    //Login
    @PostMapping("/login")
    public User loginSubmit(@RequestParam("userName") String userName, @RequestParam("name") String name){
        User user = userService.findUserByUserName(userName);
        if(user == null){
            user = userService.createUser(userName,name);
        }
        return user;
    }
    //Products
    //list products
    @GetMapping("/productList")
    public ResponseEntity<List<Product>> listProducts (){
        List<Product> products = productService.visualizarProductos();
        return ResponseEntity.ok(products);
    }

    //Shopping
    //Add to cart
    @PostMapping
    public ResponseEntity<String> addCart(@RequestParam("id") long id, @RequestBody Product product){
       boolean added = carritoCompraService.addProduct(id,product);
       if (added){
           return ResponseEntity.ok("Añadido al carrito.");
       }
       else {
           return ResponseEntity.ok("EL producto no se pudo añadir.");
       }
    }

    //remove product
    @DeleteMapping
    public ResponseEntity<String> removeProduct(@RequestParam("id") long id, @RequestBody Product product){
        boolean removed = carritoCompraService.removeProduct(id,product);
        if(removed){
            return ResponseEntity.ok("Articulo removido.");
        }
        else{
            return ResponseEntity.ok("Articulo no se pudo remover.");
        }
    }


}

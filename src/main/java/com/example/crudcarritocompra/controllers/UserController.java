package com.example.crudcarritocompra.controllers;

import com.example.crudcarritocompra.carrito.CarroCompra;
import com.example.crudcarritocompra.carrito.Product;
import com.example.crudcarritocompra.services.CarritoCompraService;
import com.example.crudcarritocompra.services.ProductService;
import com.example.crudcarritocompra.services.UserService;
import com.example.crudcarritocompra.user.User;
import jakarta.annotation.PostConstruct;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
@Controller
@RequestMapping("/")
public class UserController {

    //Parameters
    private final ProductService productService = new ProductService();
    private final CarritoCompraService carritoCompraService = new CarritoCompraService();
    private final UserService userService = new UserService();
    private final User currentUser = new User();
    //Post constructs
    @PostConstruct
    public void addProducts(){
        Product product1 = new Product("product1",BigDecimal.valueOf(40.00));
        Product product2 = new Product("product2",BigDecimal.valueOf(60.00));
        userService.createUser("admin","Admin");
        productService.crearProducto(product1);
        productService.crearProducto(product2);
    }

    //Home Page
    @GetMapping
    public String productList(Model model){
        model.addAttribute("products",productService.visualizarProductos());
        return "index";
    }
    //Login administracion
    @GetMapping("/login-adm")
    public String login(){
        return "login";
    }
    @PostMapping("/login-adm")
    public String loginSubmit(@RequestParam("username") String userName){
        User user = userService.findUserByUserName(userName);

        if(user != null){
            return "shopCart";
        }
        return "index";
    }
    //Products
    //list products
    @GetMapping("/productList")
    public ResponseEntity<List<Product>> listProducts (){
        List<Product> products = productService.visualizarProductos();
        return ResponseEntity.ok(products);
    }

    @PostMapping("/createProduct")
    public String createProduct(@ModelAttribute Product product){
        productService.crearProducto(product);
        return "redirect:/index";
    }


    //Shopping
    //list cart
    @GetMapping("/shoppingCart")
    public String cartList(Model model){
        model.addAttribute("carProducts",carritoCompraService.showProductsInCart());
        return "shopCart";
    }
    //Add to cart
    @PostMapping("/addProduct")
    public String addCart(@RequestParam("productId") long id){
        Product product = productService.findProductById(id);
       carritoCompraService.addProduct(product);
       productService.deleteProduct(id);
       return "redirect:/";
    }

    //remove product
    @DeleteMapping("/removeProduct")
    public String removeProduct(@ModelAttribute Product product){
        //TODO crea el boton para eliminar
        carritoCompraService.removeProduct(product);
        productService.crearProducto(product);
        return "redirect:/shopCart";
    }


}

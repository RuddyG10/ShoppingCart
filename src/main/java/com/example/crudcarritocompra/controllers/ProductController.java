package com.example.crudcarritocompra.controllers;

import com.example.crudcarritocompra.carrito.Product;
import com.example.crudcarritocompra.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    //


    //Create Products
    @GetMapping("/createProd")
    public String productForm(Model model){
        model.addAttribute("product",new Product());
        return "productForm";
    }
    @PostMapping("/createProd")
    public String createProduct(@ModelAttribute("product") Product product){
        productService.createProduct(product);
        return "redirect:/products";
    }



    //Last Code
//    //Parameters
//    private final ProductService productService = new ProductService();
//    private final CarritoCompraService carritoCompraService = new CarritoCompraService();
//    private final UserService userService = new UserService();
//    private final User currentUser = new User();
//    //Post constructs
//    @PostConstruct
//    public void addProducts(){
//        Product product1 = new Product("product1",BigDecimal.valueOf(40.00));
//        Product product2 = new Product("product2",BigDecimal.valueOf(60.00));
//        userService.createUser("admin","Admin");
//        productService.crearProducto(product1);
//        productService.crearProducto(product2);
//    }
//
//    //Home Page
//    @GetMapping
//    public String productList(Model model){
//        model.addAttribute("products",productService.visualizarProductos());
//        //cantidad de productos en el carrito
//        model.addAttribute("cantidad", carritoCompraService.showProductsInCart().size());
//        return "index";
//    }
//    //Login administracion
//    @GetMapping("/login-adm")
//    public String login(){
//        return "login";
//    }
//    @PostMapping("/login-adm")
//    public String loginSubmit(@RequestParam("username") String userName){
//        User user = userService.findUserByUserName(userName);
//
//        if(user != null){
//            return "shopCart";
//        }
//        return "index";
//    }
//    //Products
//    //list products
//    @GetMapping("/productList")
//    public ResponseEntity<List<Product>> listProducts (){
//        List<Product> products = productService.visualizarProductos();
//        return ResponseEntity.ok(products);
//    }
//
//    @PostMapping("/createProduct")
//    public String createProduct(@ModelAttribute Product product){
//        productService.crearProducto(product);
//        return "redirect:/index";
//    }
//
//
//    //Shopping
//    //list cart
//    @GetMapping("/shoppingCart")
//    public String cartList(Model model){
//        model.addAttribute("carProducts",carritoCompraService.showProductsInCart());
//        return "shopCart";
//    }
//    //Add to cart
//    @PostMapping("/addProduct")
//    public String addCart(@RequestParam("productId") long id){
//        Product product = productService.findProductById(id);
//       carritoCompraService.addProduct(product);
//       productService.deleteProduct(id);
//       return "redirect:/";
//    }
//
//    //remove product
//    @PostMapping("/removeProduct")
//    public String removeProduct(@RequestParam("productId") long id){
//        //TODO esta dando error verifica el metodo de remover producto.
//        Product product = productService.findProductById(id);
//        carritoCompraService.removeProduct(product);
//        productService.crearProducto(product);
//        return "shopCart";
//    }
//


}

package com.example.crudcarritocompra.services;

import com.example.crudcarritocompra.Repository.ProductRepository;
import com.example.crudcarritocompra.carrito.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //Helper
    public Product findProdById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    //Main methods
    //Create
    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    //List Products
    public List<Product> listProducts(){
        return productRepository.findAll();
    }
    //Delete Products
    public void removeProduct(Product product){
        productRepository.delete(product);
    }

    //Last Code
//    //Helper Methods
//
//    //Id generator
//
//    //Find product by id
//    public Product findProductById(long id){
//        Product auxProduct = null;
//        for (Product producto:
//             productos) {
//            if (producto.getId() == id) {
//                auxProduct = producto;
//                return auxProduct;
//            }
//
//        }
//        return auxProduct;
//    }
//
//
//    //Main methods
//
//    //Crear producto
//    public boolean crearProducto(Product product){
//        if(findProductById(product.getId()) ==null){
//
//        }
//        productos.add(product);
//        return true;
//    }
//
//    //Actualizar producto
//    public Product updateProduct(long id, String newName, BigDecimal newPrice){
//        Product auxProduct = findProductById(id);
//        if(auxProduct != null){
//            auxProduct.setName(newName);
//            auxProduct.setPrice(newPrice);
//        }
//        return auxProduct;
//    }
//
//    //Eliminar producto
//    public boolean deleteProduct(long id){
//        Product auxProduct = findProductById(id);
//        boolean deleted = false;
//
//        if (auxProduct != null){
//            productos.remove(auxProduct);
//            deleted = true;
//        }
//        return deleted;
//    }
//    //Ver productos
//    public List<Product> visualizarProductos(){
//        return productos;
//    }
}

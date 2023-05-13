package com.example.crudcarritocompra.services;

import com.example.crudcarritocompra.carrito.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> productos = new ArrayList<Product>();
    private static long idProductGenerator = 0;

    //Helper Methods

    //Id generator
    private void idGenerator() {
        idProductGenerator++;
    }

    //Find product by id
    public Product findProductById(long id){
        Product auxProduct = null;
        for (Product producto:
             productos) {
            if (producto.getId() == id) {
                auxProduct = producto;
                return auxProduct;
            }

        }
        return auxProduct;
    }


    //Main methods

    //Crear producto
    public boolean crearProducto(Product product){
        product.setId(idProductGenerator);
        productos.add(product);
        idGenerator();
        return true;
    }

    //Actualizar producto
    public Product updateProduct(long id, String newName, BigDecimal newPrice){
        Product auxProduct = findProductById(id);
        if(auxProduct != null){
            auxProduct.setName(newName);
            auxProduct.setPrice(newPrice);
        }
        return auxProduct;
    }

    //Eliminar producto
    public boolean deleteProduct(long id){
        Product auxProduct = findProductById(id);
        boolean deleted = false;

        if (auxProduct != null){
            productos.remove(auxProduct);
            deleted = true;
        }
        return deleted;
    }
    //Ver productos
    public List<Product> visualizarProductos(){
        return productos;
    }
}

package com.example.crudcarritocompra.services;

import com.example.crudcarritocompra.carrito.CarroCompra;
import com.example.crudcarritocompra.carrito.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarritoCompraService {
    //parameters
    private static long shopCartIdGen = 0;
    private List<CarroCompra> listaCarritos = new ArrayList<CarroCompra>();
    //Helper Methods
    //id generator
    public void idGenerator(){
        shopCartIdGen++;
    }

    //find shopping cart
    public CarroCompra findCartById(long id){
        CarroCompra auxCart = null;
        for (CarroCompra cart:
             listaCarritos) {
            if (cart.getId() == id){
                auxCart = cart;
                return auxCart;
            }
        }
        return auxCart;
    }

    //Main methods

    //Create Shopping Cart
    public CarroCompra createCart(Product producto){
        List<Product> listaProductos = new ArrayList<Product>();
        listaProductos.add(producto);

        CarroCompra newCart = new CarroCompra(shopCartIdGen,listaProductos);
        idGenerator();
        return newCart;
    }

    //Add Product
    public boolean addProduct(long id, Product product){
        CarroCompra auxCart = findCartById(id);
        boolean added = false;
        if (auxCart != null) {
            auxCart.getListaProductos().add(product);
            added = true;
        }
        else {
            createCart(product);
        }
        return added;

    }
    //Clear cart
    public void  removeProduct(long id,Product product){
        CarroCompra auxCart = findCartById(id);
        if(auxCart.getListaProductos().contains(product)){
            auxCart.getListaProductos().remove(product);
        }
    }

    //view products
    private List<Product> showProductsInCart(long id) {
        CarroCompra auxCart = findCartById(id);
        return auxCart.getListaProductos();
    }

    //view total
    private BigDecimal getTotalPrice(long id) {
        BigDecimal total = null;
        CarroCompra auxCart = findCartById(id);
        List<Product> products = auxCart.getListaProductos();
        for (Product product:
             products) {
            total.add(product.getPrice());
        }
        return total;
    }

}

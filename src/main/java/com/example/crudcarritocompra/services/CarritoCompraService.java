package com.example.crudcarritocompra.services;

import com.example.crudcarritocompra.carrito.CarroCompra;
import com.example.crudcarritocompra.carrito.Product;
import com.example.crudcarritocompra.carrito.VentasProductos;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CarritoCompraService {
    //parameters
    private static long shopCartIdGen = 0;
    private static long salesIdGen = 0;
    private List<CarroCompra> listaCarritos = new ArrayList<CarroCompra>();
    private List<VentasProductos> listaVentas = new ArrayList<VentasProductos>();

    //Helper Methods
    //id generator
    public void idGenerator(){
        shopCartIdGen++;
    }

    //id generator for sales
    public void idGeneratorSales(){
        salesIdGen++;
    }

    //get date
    public String getActualDate(Date date){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String formatDate = format.format(date);
        return formatDate;
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
    public boolean  removeProduct(long id,Product product){
        CarroCompra auxCart = findCartById(id);
        boolean removed = false;
        if(auxCart.getListaProductos().contains(product)){
            auxCart.getListaProductos().remove(product);
            removed = true;
        }
        return removed;
    }

    //view products
    public List<Product> showProductsInCart(long id) {
        CarroCompra auxCart = findCartById(id);
        return auxCart.getListaProductos();
    }



    //view total
    public BigDecimal getTotalPrice(long id) {
        BigDecimal total = null;
        CarroCompra auxCart = findCartById(id);
        List<Product> products = auxCart.getListaProductos();
        for (Product product:
             products) {
            total.add(product.getPrice());
        }
        return total;
    }

    //Make Purchase
    public boolean salesProcess(long id, String userName){
        CarroCompra cart = findCartById(id);
        boolean done = false;
        if(cart != null){
            registerSales(cart,userName);
            cart.getListaProductos().clear();
            done = true;
        }

        return done;

    }

    //Register sales
    public void registerSales(CarroCompra cart, String user){
        Date actualDate = new Date();
        VentasProductos venta = new VentasProductos(salesIdGen,actualDate,user,cart.getListaProductos());
        listaVentas.add(venta);
        idGeneratorSales();
    }

}

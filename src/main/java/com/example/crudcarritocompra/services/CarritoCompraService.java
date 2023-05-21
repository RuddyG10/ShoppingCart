package com.example.crudcarritocompra.services;

import com.example.crudcarritocompra.Repository.CarroRepository;
import com.example.crudcarritocompra.carrito.CarroCompra;
import com.example.crudcarritocompra.carrito.Product;
import com.example.crudcarritocompra.carrito.VentasProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CarritoCompraService {
    //parameters

    @Autowired
    private CarroRepository carroRepository;

    //Helpers
    public Optional<CarroCompra> findById(Long id){
        return carroRepository.findById(id);
    }

    //main methods
    //Create Shopping Cart
    public CarroCompra createShopCart(CarroCompra cart){
        return carroRepository.save(cart);
    }

    //list cart
    public List<CarroCompra> getAllCarts(){
        return carroRepository.findAll();
    }

    //Delete carts

    public void deleteCart(CarroCompra cart){
        carroRepository.delete(cart);
    }







    //Last Code
//    private List<Product> listaProductos = new ArrayList<Product>();
//    private List<VentasProductos> listaVentas = new ArrayList<VentasProductos>();
//
//    //Helper Methods
//    //get date
//    public String getActualDate(Date date){
//        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//        String formatDate = format.format(date);
//        return formatDate;
//    }
//    //find shopping cart
//    /*
//    public CarroCompra findCartById(long id){
//        CarroCompra auxCart = null;
//        for (CarroCompra cart:
//             listaCarritos) {
//            if (cart.getId() == id){
//                auxCart = cart;
//                return auxCart;
//            }
//        }
//        return auxCart;
//    }
//    */
//
//
//    //Main methods
//
//    //Create Shopping Cart
//    public CarroCompra createCart(Product producto){
//        List<Product> listaProductos = new ArrayList<Product>();
//        listaProductos.add(producto);
//
//        CarroCompra newCart = new CarroCompra(listaProductos);
//        return newCart;
//    }
//
//    //Add Product
//    public void addProduct(Product product){
//        listaProductos.add(product);
//        System.out.println(product.getName());
//    }
//    //Clear cart
//    public boolean  removeProduct(Product product){
//        boolean removed = false;
//        if(listaProductos.contains(product)){
//            listaProductos.remove(product);
//            removed = true;
//        }
//        return removed;
//    }
//
//    //view products
//    public List<Product> showProductsInCart() {
//        return listaProductos;
//    }
//
//    //view total
//    public BigDecimal getTotalPrice(long id) {
//        BigDecimal total = null;
//        for (Product product:
//             listaProductos) {
//            total.add(product.getPrice());
//        }
//        return total;
//    }
//
//    //Make Purchase
//    public void salesProcess(String userName){
//        boolean done = false;
//        registerSales(listaProductos,userName);
//        listaProductos.clear();
//
//    }
//
//    //Register sales
//    public void registerSales(List<Product> cart, String user){
//        Date actualDate = new Date();
//        VentasProductos venta = new VentasProductos(actualDate,user,cart);
//        listaVentas.add(venta);
//    }

}

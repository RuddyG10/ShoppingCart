package com.example.crudcarritocompra.carrito;

import java.math.BigDecimal;
import java.util.List;

public class CarroCompra {

    private long id;
    private List<Product> listaProductos;
    public static int counterCartId = 1;

    public CarroCompra() {
    }

    public CarroCompra(long id, List<Product> listaProductos) {
        this.id = id;
        this.listaProductos = listaProductos;
    }

    public long getId() {
        return id;
    }


    public List<Product> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Product> listaProductos) {
        this.listaProductos = listaProductos;
    }
}


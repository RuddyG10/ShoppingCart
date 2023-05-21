package com.example.crudcarritocompra.carrito;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "CarroCompra")
public class CarroCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> listaProductos;

    public CarroCompra() {
    }

    public CarroCompra(List<Product> listaProductos) {
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


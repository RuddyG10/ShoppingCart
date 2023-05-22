package com.example.crudcarritocompra.carrito;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ventas")
public class VentasProductos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "FechaCompra")
    private Date fechaCompra;
    @Column(name = "Cliente")
    private String clientName;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> listaProductos;

    public VentasProductos() {
    }

    public VentasProductos(Date fechaCompra, String clientName, List<Product> listaProductos) {
        this.fechaCompra = fechaCompra;
        this.clientName = clientName;
        this.listaProductos = listaProductos;
    }

    public long getId() {
        return id;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List<Product> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Product> listaProductos) {
        this.listaProductos = listaProductos;
    }
}

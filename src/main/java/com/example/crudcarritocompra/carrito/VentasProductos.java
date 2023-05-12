package com.example.crudcarritocompra.carrito;

import java.util.Date;
import java.util.List;

public class VentasProductos {
    private long id;
    private Date fechaCompra;
    private String clientName;
    private List<Product> listaProductos;

    public VentasProductos() {
    }

    public VentasProductos(long id, Date fechaCompra, String clientName, List<Product> listaProductos) {
        this.id = id;
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

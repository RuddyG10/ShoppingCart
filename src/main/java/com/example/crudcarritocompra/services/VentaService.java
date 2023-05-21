package com.example.crudcarritocompra.services;

import com.example.crudcarritocompra.Repository.VentasRepository;
import com.example.crudcarritocompra.carrito.VentasProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    @Autowired
    private VentasRepository ventasRepository;

    //Helper
    public Optional<VentasProductos> findVentaById(Long id){
        return ventasRepository.findById(id);
    }

    //Main methods
    //Create
    public VentasProductos createVenta(VentasProductos ventasProductos){
        return ventasRepository.save(ventasProductos);
    }

    //List all
    public List<VentasProductos> listVentas(){
        return ventasRepository.findAll();
    }
}

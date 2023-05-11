package com.example.crudcarritocompra.services;

import com.example.crudcarritocompra.carrito.Product;
import com.example.crudcarritocompra.carrito.VentasProductos;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VentasService {
    //Parameters
    private List<VentasProductos> listaVentas = new ArrayList<VentasProductos>();
    private static long salesIdGen = 0;
    //Helper Methods

    public void idGenerator(){
        salesIdGen++;
    }
    public String getActualDate(Date date){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String formatDate = format.format(date);
        return formatDate;
    }


    //Main Methods
    //TODO termina el proceso de ventas.
}

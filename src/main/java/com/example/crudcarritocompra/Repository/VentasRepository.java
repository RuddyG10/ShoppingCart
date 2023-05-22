package com.example.crudcarritocompra.Repository;

import com.example.crudcarritocompra.carrito.VentasProductos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentasRepository extends JpaRepository<VentasProductos,Long> {
}

package com.example.crudcarritocompra.Repository;

import com.example.crudcarritocompra.carrito.CarroCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<CarroCompra,Long> {
}

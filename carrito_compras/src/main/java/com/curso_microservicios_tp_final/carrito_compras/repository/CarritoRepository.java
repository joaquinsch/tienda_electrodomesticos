package com.curso_microservicios_tp_final.carrito_compras.repository;

import com.curso_microservicios_tp_final.carrito_compras.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito,Long> {

}

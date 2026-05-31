package com.curso_microservicios_tp_final.productos_service.repository;

import com.curso_microservicios_tp_final.productos_service.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}

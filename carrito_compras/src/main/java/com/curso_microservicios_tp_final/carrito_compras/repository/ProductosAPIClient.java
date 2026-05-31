package com.curso_microservicios_tp_final.carrito_compras.repository;

import com.curso_microservicios_tp_final.carrito_compras.dto.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "productos-service")
public interface ProductosAPIClient {

    @GetMapping("/productos/{codigo_producto}")
    ProductoDTO obtenerProducto(@PathVariable Long codigo_producto);


}

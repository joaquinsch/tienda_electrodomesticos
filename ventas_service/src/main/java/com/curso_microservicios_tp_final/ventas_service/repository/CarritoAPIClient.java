package com.curso_microservicios_tp_final.ventas_service.repository;

import com.curso_microservicios_tp_final.ventas_service.dto.CarritoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "carrito-compras")
public interface CarritoAPIClient {

    @GetMapping("/carrito/{id_carrito}")
    CarritoDTO obtenerCarrito(@PathVariable Long id_carrito);

}

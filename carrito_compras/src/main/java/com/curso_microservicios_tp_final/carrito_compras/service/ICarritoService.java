package com.curso_microservicios_tp_final.carrito_compras.service;


import com.curso_microservicios_tp_final.carrito_compras.dto.CarritoDTO;
import com.curso_microservicios_tp_final.carrito_compras.dto.CarritoResponseDTO;

public interface ICarritoService {
    CarritoResponseDTO crearCarrito(CarritoDTO carrito);
    CarritoResponseDTO obtenerCarrito(Long id_carrito);
}

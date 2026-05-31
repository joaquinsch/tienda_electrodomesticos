package com.curso_microservicios_tp_final.productos_service.service;

import com.curso_microservicios_tp_final.productos_service.model.Producto;

import java.util.List;

public interface IProductoService {
    List<Producto> obtenerProductos();
    Producto obtenerProducto(Long codigo_producto);
    Producto crearProducto(Producto producto);
}

package com.curso_microservicios_tp_final.productos_service.service;

import com.curso_microservicios_tp_final.productos_service.model.Producto;
import com.curso_microservicios_tp_final.productos_service.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{

    private ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }


    @Override
    public List<Producto> obtenerProductos() {
        return productoRepository.findAll();
    }
}

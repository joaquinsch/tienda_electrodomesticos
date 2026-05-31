package com.curso_microservicios_tp_final.productos_service.service;

import com.curso_microservicios_tp_final.productos_service.exceptions.ProductoInexistenteError;
import com.curso_microservicios_tp_final.productos_service.model.Producto;
import com.curso_microservicios_tp_final.productos_service.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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

    private Producto buscarProducto(Long codigo_producto) {
        return productoRepository.findById(codigo_producto)
                .orElseThrow(() -> new ProductoInexistenteError("No se encontró el producto con codigo: " + codigo_producto));
    }

    @Override
    public Producto obtenerProducto(Long codigo_producto) {
        return buscarProducto(codigo_producto);
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }
}

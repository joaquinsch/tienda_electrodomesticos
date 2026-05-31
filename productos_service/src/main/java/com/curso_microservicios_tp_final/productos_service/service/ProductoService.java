package com.curso_microservicios_tp_final.productos_service.service;

import com.curso_microservicios_tp_final.productos_service.exceptions.ProductoInexistenteError;
import com.curso_microservicios_tp_final.productos_service.model.Producto;
import com.curso_microservicios_tp_final.productos_service.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements IProductoService {

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
                .orElseThrow(() -> new ProductoInexistenteError("No se encontró el producto con código: " + codigo_producto));
    }

    @Override
    public Producto obtenerProducto(Long codigo_producto) {
        return buscarProducto(codigo_producto);
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> obtenerProductosDeCarrito(List<Long> codigo_productos) {
        List<Producto> productosRecuperados = productoRepository.findAllById(codigo_productos);

        if (productosRecuperados.size() != codigo_productos.size()) {
            List<Long> encontradosIds = new ArrayList<>();
            for (Producto p : productosRecuperados) {
                encontradosIds.add(p.getCodigo_producto());
            }

            List<Long> noEncontrados = new ArrayList<>();
            for (Long id : codigo_productos) {
                if (!encontradosIds.contains(id)) {
                    noEncontrados.add(id);
                }
            }

            throw new ProductoInexistenteError("No se encontraron los productos con códigos: " + noEncontrados);
        }
        return productosRecuperados;
    }
}

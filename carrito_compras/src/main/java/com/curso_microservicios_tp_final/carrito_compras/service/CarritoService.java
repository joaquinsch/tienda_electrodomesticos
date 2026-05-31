package com.curso_microservicios_tp_final.carrito_compras.service;

import com.curso_microservicios_tp_final.carrito_compras.dto.ProductoDTO;
import com.curso_microservicios_tp_final.carrito_compras.model.Carrito;
import com.curso_microservicios_tp_final.carrito_compras.repository.CarritoRepository;
import com.curso_microservicios_tp_final.carrito_compras.repository.ProductosAPIClient;
import org.springframework.stereotype.Service;

@Service
public class CarritoService implements ICarritoService {

    private final CarritoRepository carritoRepository;
    private final ProductosAPIClient productosAPIClient;

    public CarritoService(CarritoRepository carritoRepository, ProductosAPIClient productosAPIClient) {
        this.carritoRepository = carritoRepository;
        this.productosAPIClient = productosAPIClient;
    }

    @Override
    public Carrito crearCarrito(Carrito carrito) {
        verificarProductos(carrito);
        return carritoRepository.save(carrito);
    }

    private void verificarProductos(Carrito carrito) {
        for (ProductoDTO prod : carrito.getLista_productos()){
            ProductoDTO actual = productosAPIClient.obtenerProducto(prod.getCodigo_producto());
        }
    }

}

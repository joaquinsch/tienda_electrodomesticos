package com.curso_microservicios_tp_final.carrito_compras.service;

import com.curso_microservicios_tp_final.carrito_compras.dto.ProductoDTO;
import com.curso_microservicios_tp_final.carrito_compras.model.Carrito;
import com.curso_microservicios_tp_final.carrito_compras.repository.CarritoRepository;
import com.curso_microservicios_tp_final.carrito_compras.repository.ProductosAPIClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        List<ProductoDTO> productosVerificados = obtenerProductos(carrito);
        carrito.setLista_productos(productosVerificados);
        return carritoRepository.save(carrito);
    }

    private List<ProductoDTO> obtenerProductos(Carrito carrito) {
        List<ProductoDTO> productosRecuperados = new ArrayList<>();
        for (ProductoDTO prod : carrito.getLista_productos()){
            // si no lo encuentra tira una excepcion
            ProductoDTO actual = productosAPIClient.obtenerProducto(prod.getCodigo_producto());
            productosRecuperados.add(actual);
        }
        return productosRecuperados;
    }

}

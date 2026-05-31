package com.curso_microservicios_tp_final.carrito_compras.service;

import com.curso_microservicios_tp_final.carrito_compras.dto.CarritoDTO;
import com.curso_microservicios_tp_final.carrito_compras.dto.CarritoResponseDTO;
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
    public CarritoResponseDTO crearCarrito(CarritoDTO carritoDTO) {
        Carrito carritoGuardado = new Carrito();

        List<ProductoDTO> productosVerificados = obtenerProductos(carritoDTO);
        carritoGuardado.setPrecio_total(obtenerPrecioTotal(carritoDTO));
        carritoGuardado.setLista_productos(productosVerificados);
        Carrito guardado = carritoRepository.save(carritoGuardado);

        CarritoResponseDTO devuelto = new CarritoResponseDTO();
        devuelto.setId_carrito(carritoGuardado.getId_carrito());
        devuelto.setPrecio_total(carritoGuardado.getPrecio_total());
        devuelto.setLista_productos(carritoGuardado.getLista_productos());
        return devuelto;

    }

    private List<ProductoDTO> obtenerProductos(CarritoDTO carrito) {
        List<ProductoDTO> productosRecuperados = new ArrayList<>();
        for (Long codigo_producto : carrito.getLista_productos()){
            // si no lo encuentra tira una excepcion
            ProductoDTO actual = productosAPIClient.obtenerProducto(codigo_producto);
            productosRecuperados.add(actual);
        }
        return productosRecuperados;
    }

    private Double obtenerPrecioTotal(CarritoDTO carrito) {
        List<ProductoDTO> productosRecuperados = obtenerProductos(carrito);
        Double precio_total = 0.0;
        for (ProductoDTO prod : productosRecuperados) {
            precio_total += prod.getPrecio();
        }
        return precio_total;
    }

}

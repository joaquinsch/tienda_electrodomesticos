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
        Carrito carritoAGuardar = new Carrito();

        List<ProductoDTO> productosVerificados = obtenerProductos(carritoDTO);

        carritoAGuardar.setPrecio_total(obtenerPrecioTotal(productosVerificados));
        carritoAGuardar.setLista_codigo_productos(obtenerIdsProductos(productosVerificados));
        Carrito guardado = carritoRepository.save(carritoAGuardar);

        CarritoResponseDTO devuelto = new CarritoResponseDTO();
        devuelto.setId_carrito(guardado.getId_carrito());
        devuelto.setPrecio_total(guardado.getPrecio_total());
        devuelto.setLista_ids_productos(guardado.getLista_codigo_productos());
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

    private List<Long> obtenerIdsProductos(List<ProductoDTO> productos) {
        List<Long> ids = new ArrayList<>();
        for (ProductoDTO prod : productos) {
            ids.add(prod.getCodigo_producto());
        }
        return ids;
    }

    private Double obtenerPrecioTotal(List<ProductoDTO> productos) {
        Double precio_total = 0.0;
        for (ProductoDTO prod : productos) {
            precio_total += prod.getPrecio();
        }
        return precio_total;
    }

}

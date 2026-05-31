package com.curso_microservicios_tp_final.carrito_compras.service;

import com.curso_microservicios_tp_final.carrito_compras.dto.CarritoDTO;
import com.curso_microservicios_tp_final.carrito_compras.dto.CarritoResponseDTO;
import com.curso_microservicios_tp_final.carrito_compras.dto.ProductoDTO;
import com.curso_microservicios_tp_final.carrito_compras.exceptions.CarritoInexistenteError;
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

        List<ProductoDTO> productosVerificados = productosAPIClient.obtenerProductosDeCarrito(carritoDTO.getLista_codigo_productos());

        carritoAGuardar.setPrecio_total(obtenerPrecioTotal(productosVerificados));
        carritoAGuardar.setLista_codigo_productos(obtenerIdsProductos(productosVerificados));
        Carrito guardado = carritoRepository.save(carritoAGuardar);

        CarritoResponseDTO devuelto = new CarritoResponseDTO();
        devuelto.setId_carrito(guardado.getId_carrito());
        devuelto.setPrecio_total(guardado.getPrecio_total());
        devuelto.setLista_productos(productosVerificados);
        return devuelto;

    }

    @Override
    public CarritoResponseDTO obtenerCarrito(Long id_carrito) {
        Carrito buscado = buscarCarrito(id_carrito);

        CarritoResponseDTO devuelto = new CarritoResponseDTO();
        devuelto.setId_carrito(buscado.getId_carrito());
        devuelto.setPrecio_total(buscado.getPrecio_total());
        devuelto.setLista_productos(productosAPIClient.obtenerProductosDeCarrito(buscado.getLista_codigo_productos()));
        return devuelto;
    }

    private Carrito buscarCarrito(Long id_carrito) {
        return carritoRepository.findById(id_carrito)
                .orElseThrow(() -> new CarritoInexistenteError("No se encontró el carrito con id: " + id_carrito));
    }


    private List<Long> obtenerIdsProductos(List<ProductoDTO> productos) {
        List<Long> codigos = new ArrayList<>();
        for (ProductoDTO prod : productos) {
            codigos.add(prod.getCodigo_producto());
        }
        return codigos;
    }

    private Double obtenerPrecioTotal(List<ProductoDTO> productos) {
        Double precio_total = 0.0;
        for (ProductoDTO prod : productos) {
            precio_total += prod.getPrecio();
        }
        return precio_total;
    }

}

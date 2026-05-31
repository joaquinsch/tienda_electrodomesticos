package com.curso_microservicios_tp_final.ventas_service.service;

import com.curso_microservicios_tp_final.ventas_service.dto.CarritoDTO;
import com.curso_microservicios_tp_final.ventas_service.dto.VentaDTO;
import com.curso_microservicios_tp_final.ventas_service.model.Venta;
import com.curso_microservicios_tp_final.ventas_service.repository.CarritoAPIClient;
import com.curso_microservicios_tp_final.ventas_service.repository.VentaRepository;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{
    private final VentaRepository ventaRepository;
    private final CarritoAPIClient carritoAPIClient;

    public VentaService(VentaRepository ventaRepository, CarritoAPIClient carritoAPIClient) {
        this.ventaRepository = ventaRepository;
        this.carritoAPIClient = carritoAPIClient;
    }

    @Override
    public VentaDTO crearVenta(VentaDTO ventaDTO) {
        Venta datosVenta = new Venta();
        datosVenta.setId_venta(ventaDTO.getId_venta());
        datosVenta.setFecha(ventaDTO.getFecha());
        CarritoDTO carritoDTO = obtenerCarrito(ventaDTO.getId_carrito());
        datosVenta.setId_carrito(carritoDTO.getId_carrito());
        Venta guardada = ventaRepository.save(datosVenta);

        VentaDTO devuelta = new VentaDTO();
        devuelta.setId_venta(guardada.getId_venta());
        devuelta.setFecha(guardada.getFecha());
        devuelta.setId_carrito(guardada.getId_carrito());
        return devuelta;
    }

    private CarritoDTO obtenerCarrito(Long id_carrito) {
        return carritoAPIClient.obtenerCarrito(id_carrito);
    }
}

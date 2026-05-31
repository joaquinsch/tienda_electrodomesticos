package com.curso_microservicios_tp_final.ventas_service.controller;

import com.curso_microservicios_tp_final.ventas_service.dto.VentaDTO;
import com.curso_microservicios_tp_final.ventas_service.service.IVentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ventas")
public class VentaController {
    private final IVentaService ventaService;

    public VentaController(IVentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping
    public ResponseEntity<VentaDTO> crearVenta(@RequestBody VentaDTO ventaDTO) {
        return new ResponseEntity<>(ventaService.crearVenta(ventaDTO), HttpStatus.CREATED);

    }
}

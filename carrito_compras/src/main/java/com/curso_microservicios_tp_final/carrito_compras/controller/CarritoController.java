package com.curso_microservicios_tp_final.carrito_compras.controller;

import com.curso_microservicios_tp_final.carrito_compras.model.Carrito;
import com.curso_microservicios_tp_final.carrito_compras.service.ICarritoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/carrito")
public class CarritoController {
    private final ICarritoService carritoService;

    public CarritoController(ICarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @PostMapping
    public ResponseEntity<Carrito> crearCarrito(@RequestBody Carrito carrito) {
        Carrito creado = carritoService.crearCarrito(carrito);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }
}

package com.curso_microservicios_tp_final.carrito_compras.controller;

import com.curso_microservicios_tp_final.carrito_compras.dto.CarritoDTO;
import com.curso_microservicios_tp_final.carrito_compras.dto.CarritoResponseDTO;
import com.curso_microservicios_tp_final.carrito_compras.service.ICarritoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrito")
public class CarritoController {
    private final ICarritoService carritoService;

    public CarritoController(ICarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @PostMapping
    public ResponseEntity<CarritoResponseDTO> crearCarrito(@RequestBody CarritoDTO carrito) {
        CarritoResponseDTO creado = carritoService.crearCarrito(carrito);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @GetMapping("/{id_carrito}")
    public ResponseEntity<CarritoResponseDTO> obtenerCarrito(@PathVariable Long id_carrito){
        return new ResponseEntity<>(carritoService.obtenerCarrito(id_carrito), HttpStatus.OK);
    }
}

package com.curso_microservicios_tp_final.productos_service.controller;

import com.curso_microservicios_tp_final.productos_service.model.Producto;
import com.curso_microservicios_tp_final.productos_service.service.IProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    private final IProductoService productoService;

    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> obtenerProductos() {
         List<Producto> productos = productoService.obtenerProductos();
         return ResponseEntity.ok(productos);
    }

    @GetMapping("/{codigo_producto}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Long codigo_producto){
        return new ResponseEntity<>(productoService.obtenerProducto(codigo_producto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto){
        return new ResponseEntity<>(productoService.crearProducto(producto), HttpStatus.CREATED);
    }
}

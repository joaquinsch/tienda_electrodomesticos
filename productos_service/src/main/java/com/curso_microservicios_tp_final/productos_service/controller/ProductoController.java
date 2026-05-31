package com.curso_microservicios_tp_final.productos_service.controller;

import com.curso_microservicios_tp_final.productos_service.model.Producto;
import com.curso_microservicios_tp_final.productos_service.service.IProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/productos")
public class ProductoController {
    private final IProductoService productoService;

    @Value("${server.port}")
    private String puerto;

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
        //log.info("Request en el puerto: {}", puerto);
        return new ResponseEntity<>(productoService.obtenerProducto(codigo_producto), HttpStatus.OK);
    }

    @GetMapping("/buscados")
    public ResponseEntity<List<Producto>> obtenerProductosDeCarrito(@RequestParam List<Long> codigo_productos){
        log.info("Request en el puerto: {}", puerto);
        return new ResponseEntity<>(productoService.obtenerProductosDeCarrito(codigo_productos), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto){
        return new ResponseEntity<>(productoService.crearProducto(producto), HttpStatus.CREATED);
    }
}

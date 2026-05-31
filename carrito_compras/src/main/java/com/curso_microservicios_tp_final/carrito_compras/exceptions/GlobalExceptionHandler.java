package com.curso_microservicios_tp_final.carrito_compras.exceptions;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FeignException.NotFound.class)
    public ResponseEntity<String> handleProductoInexistenteError(FeignException.NotFound e){
        String mensaje = e.contentUTF8(); // esto trae el body de la respuesta de productos
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(mensaje);
    }

    @ExceptionHandler(CarritoInexistenteError.class)
    public ResponseEntity<String> handleCarritoInexistenteError(CarritoInexistenteError e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(e.getMessage());
    }

}
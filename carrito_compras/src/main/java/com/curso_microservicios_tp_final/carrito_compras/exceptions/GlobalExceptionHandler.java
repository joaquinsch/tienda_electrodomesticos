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
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(e.contentUTF8());
    }

    @ExceptionHandler(CarritoInexistenteError.class)
    public ResponseEntity<ApiError> handleCarritoInexistenteError(CarritoInexistenteError e) {
        ApiError apiError = new ApiError(e.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ComunicacionConProductosError.class)
    public ResponseEntity<String> handleComunicacionConProductosError(ComunicacionConProductosError e){
        return ResponseEntity.status(e.getStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(e.getMessage());

    }

}
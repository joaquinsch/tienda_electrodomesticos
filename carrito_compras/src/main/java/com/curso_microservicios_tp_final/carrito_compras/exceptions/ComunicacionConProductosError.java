package com.curso_microservicios_tp_final.carrito_compras.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ComunicacionConProductosError extends RuntimeException{
    private final HttpStatus status;

    public ComunicacionConProductosError(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

}

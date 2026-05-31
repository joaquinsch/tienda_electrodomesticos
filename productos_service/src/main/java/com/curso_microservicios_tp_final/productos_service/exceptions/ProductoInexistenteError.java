package com.curso_microservicios_tp_final.productos_service.exceptions;


public class ProductoInexistenteError extends RuntimeException{
    private String mensaje;

    public ProductoInexistenteError(String message) {
        super(message);

    }
}

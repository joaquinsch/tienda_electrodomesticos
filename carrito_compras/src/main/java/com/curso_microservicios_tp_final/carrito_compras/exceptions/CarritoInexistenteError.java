package com.curso_microservicios_tp_final.carrito_compras.exceptions;

public class CarritoInexistenteError extends RuntimeException{

    public CarritoInexistenteError(String message) {
        super(message);
    }
}

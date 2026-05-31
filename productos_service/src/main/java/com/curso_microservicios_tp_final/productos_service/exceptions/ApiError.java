package com.curso_microservicios_tp_final.productos_service.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiError {
    private String mensaje;
}

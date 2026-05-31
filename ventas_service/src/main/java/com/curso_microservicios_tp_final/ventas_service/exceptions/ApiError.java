package com.curso_microservicios_tp_final.ventas_service.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiError {
    private String mensaje;
}
package com.curso_microservicios_tp_final.ventas_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
    private Long codigo_producto;
    private String nombre;
    private String marca;
    private Double precio;
}

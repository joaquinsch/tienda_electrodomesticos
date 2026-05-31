package com.curso_microservicios_tp_final.carrito_compras.dto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ProductoDTO {
    private Long codigo_producto;
    private String nombre;
    private String marca;
    private Double precio;
}

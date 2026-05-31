package com.curso_microservicios_tp_final.carrito_compras.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarritoResponseDTO {
    private Long id_carrito;
    private Double precio_total;
    private List<Long> lista_ids_productos;
}

package com.curso_microservicios_tp_final.carrito_compras.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarritoDTO {
    private List<Long> lista_productos;
}

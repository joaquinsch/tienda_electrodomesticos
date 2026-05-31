package com.curso_microservicios_tp_final.carrito_compras.model;


import com.curso_microservicios_tp_final.carrito_compras.dto.ProductoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carrito;
    private Double precio_total;
    @CollectionTable(
            name = "carrito_productos",
            joinColumns = @JoinColumn(name = "id_carrito")
    )
    @Column(name = "codigo_producto")
    private List<Long> lista_codigo_productos;
}

package com.liver.gil.gestionpedidos.pedido.domain.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Entity que representa la información de un Pedido.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "pedidos")
public class Pedido {

    @Id
    private String itemId;
    private int cantidad;
    private String canalDeVenta;
    private String estatusPedido;
    private String userId;
}

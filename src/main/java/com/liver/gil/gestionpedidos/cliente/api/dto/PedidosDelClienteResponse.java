package com.liver.gil.gestionpedidos.cliente.api.dto;

import java.util.List;

/**
 * Record para representar la información de los Pedidos del Cliente.
 */
public record PedidosDelClienteResponse(
    String orderRef,
    String userId,
    String canal,
    String orderStatus,
    boolean marketPlace,
    boolean giftRegistry,
    List<String> items,
    String storeName,
    String id
){

}

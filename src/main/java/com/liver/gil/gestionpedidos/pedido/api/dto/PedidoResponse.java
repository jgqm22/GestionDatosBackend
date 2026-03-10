package com.liver.gil.gestionpedidos.pedido.api.dto;

/**
 * Record para representar la información a devolver relativa a un Pedido.
 * @param itemId
 * @param cantidad
 * @param canalDeVenta
 * @param estatusPedido
 */
public record PedidoResponse(
        String itemId,
        int cantidad,
        String canalDeVenta,
        String estatusPedido
) {
}

package com.liver.gil.gestionpedidos.pedido.api.dto;

/**
 * Record para representar el Request cuando se envían los datos del Pedido.
 * @param cantidad
 * @param canalDeVenta
 * @param estatusPedido
 */
public record PedidoRequest(
        int cantidad,
        String canalDeVenta,
        String estatusPedido
) {
}

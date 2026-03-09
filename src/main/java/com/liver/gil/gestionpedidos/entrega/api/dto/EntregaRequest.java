package com.liver.gil.gestionpedidos.entrega.api.dto;

/**
 * Record para representar el Request de la dirección de Entrega del pedido.
 * @param calle
 * @param ciudad
 * @param codigoPostal
 */
public record EntregaRequest(
        String calle,
        String ciudad,
        String codigoPostal
) {
}

package com.liver.gil.gestionpedidos.entrega.api.dto;

/**
 * Record para representar la dirección de Entrega de un Pedido.
 * @param id
 * @param calle
 * @param ciudad
 * @param codigoPostal
 */
public record EntregaResponse(
        String id,
        String calle,
        String ciudad,
        String codigoPostal
) {
}

package com.liver.gil.gestionpedidos.cliente.api.dto;

/**
 * Record para representar el Response cuando se recupera el Cliente.
 *
 * @param userId
 * @param nombre
 * @param apellidoPaterno
 * @param apellidoMaterno
 * @param correoElectronico
 */
public record ClienteResponse(
        String userId,
        String nombre,
        String apellidoPaterno,
        String apellidoMaterno,
        String correoElectronico

) {
}

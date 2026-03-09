package com.liver.gil.gestionpedidos.cliente.api.dto;

/**
 * Record para representar el Request cuando se envían los datos del Cliente.
 *
 * @param nombre
 * @param apellidoPaterno
 * @param apellidoMaterno
 * @param correoElectronico
 */
public record ClienteRequest(
        String nombre,
        String apellidoPaterno,
        String apellidoMaterno,
        String correoElectronico
) {
}

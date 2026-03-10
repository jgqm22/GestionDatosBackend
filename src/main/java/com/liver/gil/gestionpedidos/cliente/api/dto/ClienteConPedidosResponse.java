package com.liver.gil.gestionpedidos.cliente.api.dto;

import java.util.List;

/**
 * Record que representa la información a regresar en el Servicio REST con el detalle del usuario y sus pedidos que fueron recuperados con el cliente REST.
 * @param userId
 * @param nombre
 * @param apellidoPaterno
 * @param apellidoMaterno
 * @param correoElectronico
 * @param orders
 */
public record ClienteConPedidosResponse(
    String userId,
    String nombre,
    String apellidoPaterno,
    String apellidoMaterno,
    String correoElectronico,
    List<PedidosDelClienteResponse> orders
) {

}

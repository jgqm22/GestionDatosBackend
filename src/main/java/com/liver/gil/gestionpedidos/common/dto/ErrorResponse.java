package com.liver.gil.gestionpedidos.common.dto;

public record ErrorResponse(
        int estatus,
        String mensaje
) {
}

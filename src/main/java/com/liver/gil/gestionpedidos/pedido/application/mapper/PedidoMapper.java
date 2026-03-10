package com.liver.gil.gestionpedidos.pedido.application.mapper;

import com.liver.gil.gestionpedidos.cliente.api.dto.ClienteRequest;
import com.liver.gil.gestionpedidos.cliente.api.dto.ClienteResponse;
import com.liver.gil.gestionpedidos.cliente.domain.model.Cliente;
import com.liver.gil.gestionpedidos.pedido.api.dto.PedidoRequest;
import com.liver.gil.gestionpedidos.pedido.api.dto.PedidoResponse;
import com.liver.gil.gestionpedidos.pedido.domain.model.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper para la Entity Pedido y sus respectivos Response y Request.
 */
@Mapper(componentModel = "spring")
public interface PedidoMapper {
    /**
     * Convierte el Request al Entity.
     *
     * @param request
     * @return
     */
    @Mapping(target = "itemId", ignore = true)
    Pedido toEntity(PedidoRequest request);

    /**
     * Convierte el Entity al Response.
     *
     * @param pedido
     * @return
     */
    PedidoResponse toResponse(Pedido pedido);

    /**
     * Convierte una lista de entidades Pedido a una lista de Response de Pedido.
     *
     * @param pedidos
     * @return
     */
    List<PedidoResponse> toResponseList(List<Pedido> pedidos);
}

package com.liver.gil.gestionpedidos.cliente.application.mapper;

import com.liver.gil.gestionpedidos.cliente.api.dto.ClienteRequest;
import com.liver.gil.gestionpedidos.cliente.api.dto.ClienteResponse;
import com.liver.gil.gestionpedidos.cliente.domain.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper para la Entity Cliente y sus respectivos Response y Request.
 */
@Mapper(componentModel = "spring")
public interface ClienteMapper {

    /**
     * Convierte el Request al Entity.
     *
     * @param request
     * @return
     */
    @Mapping(target = "id", ignore = true)
    Cliente toEntity(ClienteRequest request);

    /**
     * Convierte el Entity al Response.
     *
     * @param cliente
     * @return
     */
    ClienteResponse toResponse(Cliente cliente);

    /**
     * Convierte una lista de entidades Cliente a una lista de Response de Clientes.
     *
     * @param clientes
     * @return
     */
    List<ClienteResponse> toResponseList(List<Cliente> clientes);
}

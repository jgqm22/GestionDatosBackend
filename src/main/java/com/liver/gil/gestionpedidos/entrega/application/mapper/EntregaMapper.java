package com.liver.gil.gestionpedidos.entrega.application.mapper;

import com.liver.gil.gestionpedidos.entrega.api.dto.EntregaRequest;
import com.liver.gil.gestionpedidos.entrega.api.dto.EntregaResponse;
import com.liver.gil.gestionpedidos.entrega.domain.model.Entrega;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper para el Entity Entrega y sus respectivos Request y Response.
 */
@Mapper(componentModel = "spring")
public interface EntregaMapper {

    /**
     * Convierte el Request al Entity.
     *
     * @param request
     * @return
     */
    @Mapping(target = "id", ignore = true)
    Entrega toEntity(EntregaRequest request);

    /**
     * Convierte el Entity al Response.
     *
     * @param entrega
     * @return
     */
    EntregaResponse toResponse(Entrega entrega);

    /**
     * Convierte una lista de entidades Entrega a una lista de Response de Entregas.
     *
     * @param entregas
     * @return
     */
    List<EntregaResponse> toResponseList(List<Entrega> entregas);

}

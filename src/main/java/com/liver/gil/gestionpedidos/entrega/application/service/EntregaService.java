package com.liver.gil.gestionpedidos.entrega.application.service;

import com.liver.gil.gestionpedidos.common.exception.ObjetoNoEncontradoException;
import com.liver.gil.gestionpedidos.entrega.api.dto.EntregaRequest;
import com.liver.gil.gestionpedidos.entrega.api.dto.EntregaResponse;
import com.liver.gil.gestionpedidos.entrega.application.mapper.EntregaMapper;
import com.liver.gil.gestionpedidos.entrega.domain.model.Entrega;
import com.liver.gil.gestionpedidos.entrega.infraestructure.repository.EntregaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service para gestionar lo relativo a una Entrega usando el Repository correspondiente.
 */
@Service
public class EntregaService {

    private final EntregaRepository entregaRepository;
    private final EntregaMapper entregaMapper;

    /**
     * Constructor.
     *
     * @param entregaRepository
     * @param entregaMapper
     */
    public EntregaService(EntregaRepository entregaRepository,
                          EntregaMapper entregaMapper) {
        this.entregaRepository = entregaRepository;
        this.entregaMapper = entregaMapper;
    }

    /**
     * Inserta una entrega.
     *
     * @param entregaRequest
     * @return
     */
    public EntregaResponse guardarEntrega(EntregaRequest entregaRequest) {
        Entrega entrega = this.entregaMapper.toEntity(entregaRequest);
        return this.entregaMapper.toResponse(this.entregaRepository.save(entrega));
    }

    /**
     * Actualiza una Entrega existente que encuentre por su id.
     *
     * @param id
     * @param entregaRequest
     * @return
     */
    public EntregaResponse actualizaEntrega(String id, EntregaRequest entregaRequest) {
        Entrega entrega = entregaRepository.findById(id).orElseThrow(() -> new ObjetoNoEncontradoException(id));
        entrega.setCalle(entregaRequest.calle());
        entrega.setCiudad(entregaRequest.ciudad());
        entrega.setCodigoPostal(entregaRequest.codigoPostal());
        return this.entregaMapper.toResponse(this.entregaRepository.save(entrega));
    }

    /**
     * Recupera una lista con todas las entregas desde el repositorio.
     *
     * @return
     */
    public List<EntregaResponse> obtenerEntregas() {
        return this.entregaMapper.toResponseList(this.entregaRepository.findAll());
    }

    /**
     * Recupera una entrega desde el Repositorio, en caso de que no exista lanza una excepción.
     *
     * @param id
     * @return
     */
    public EntregaResponse obtenerEntregaPorId(String id) {
        Entrega entrega = entregaRepository.findById(id).orElseThrow(() -> new ObjetoNoEncontradoException(id));
        return this.entregaMapper.toResponse(entrega);
    }

    /**
     * Borra una Entrega del Repositorio.
     *
     * @param id
     */
    public void borrarEntrega(String id) {
        this.entregaRepository.deleteById(id);
    }

}

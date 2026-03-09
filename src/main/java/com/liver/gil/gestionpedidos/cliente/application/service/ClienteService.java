package com.liver.gil.gestionpedidos.cliente.application.service;

import com.liver.gil.gestionpedidos.cliente.api.dto.ClienteRequest;
import com.liver.gil.gestionpedidos.cliente.api.dto.ClienteResponse;
import com.liver.gil.gestionpedidos.cliente.application.mapper.ClienteMapper;
import com.liver.gil.gestionpedidos.cliente.domain.model.Cliente;
import com.liver.gil.gestionpedidos.cliente.infraestructure.repository.ClienteRepository;
import com.liver.gil.gestionpedidos.common.exception.ObjetoNoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service para gestionar lo relativo al Cliente usando el Repository correspondiente.
 */
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    /**
     * Constructor.
     *
     * @param clienteRepository
     * @param clienteMapper
     */
    public ClienteService(ClienteRepository clienteRepository,
                          ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    /**
     * Inserta un cliente.
     *
     * @param clienteRequest
     * @return
     */
    public ClienteResponse guardarCliente(ClienteRequest clienteRequest) {
        Cliente cliente = this.clienteMapper.toEntity(clienteRequest);
        return this.clienteMapper.toResponse(this.clienteRepository.save(cliente));
    }

    /**
     * Actualiza un Cliente existente que encuentre por su id.
     *
     * @param id
     * @param clienteRequest
     * @return
     */
    public ClienteResponse actualizaCliente(String id, ClienteRequest clienteRequest) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ObjetoNoEncontradoException(id));
        cliente.setNombre(clienteRequest.nombre());
        cliente.setApellidoPaterno(clienteRequest.apellidoPaterno());
        cliente.setApellidoMaterno(clienteRequest.apellidoMaterno());
        cliente.setCorreoElectronico(clienteRequest.correoElectronico());
        return this.clienteMapper.toResponse(this.clienteRepository.save(cliente));
    }

    /**
     * Recupera una lista con todos los clientes desde el repositorio.
     *
     * @return
     */
    public List<ClienteResponse> obtenerClientes() {
        return this.clienteMapper.toResponseList(this.clienteRepository.findAll());
    }

    /**
     * Recupera un cliente desde el Repositorio, en caso de que no exista lanza una excepción.
     *
     * @param id
     * @return
     */
    public ClienteResponse obtenerClientePorId(String id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ObjetoNoEncontradoException(id));
        return this.clienteMapper.toResponse(cliente);
    }

    /**
     * Borra un Cliente del Repositorio.
     *
     * @param id
     */
    public void borrarCliente(String id) {
        this.clienteRepository.deleteById(id);
    }

}

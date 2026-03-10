package com.liver.gil.gestionpedidos.pedido.application.service;

import com.liver.gil.gestionpedidos.cliente.api.dto.ClienteRequest;
import com.liver.gil.gestionpedidos.cliente.api.dto.ClienteResponse;
import com.liver.gil.gestionpedidos.cliente.domain.model.Cliente;
import com.liver.gil.gestionpedidos.common.exception.ObjetoNoEncontradoException;
import com.liver.gil.gestionpedidos.pedido.api.dto.PedidoRequest;
import com.liver.gil.gestionpedidos.pedido.api.dto.PedidoResponse;
import com.liver.gil.gestionpedidos.pedido.application.mapper.PedidoMapper;
import com.liver.gil.gestionpedidos.pedido.domain.model.Pedido;
import com.liver.gil.gestionpedidos.pedido.infraestructure.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service para gestionar la información de Pedido.
 */
@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;

    /**
     * Constructor.
     * @param pedidoRepository
     * @param pedidoMapper
     */
    public PedidoService(PedidoRepository pedidoRepository,
                         PedidoMapper pedidoMapper){
        this.pedidoRepository = pedidoRepository;
        this.pedidoMapper = pedidoMapper;
    }

    /**
     * Inserta un pedido.
     *
     * @param pedidoRequest
     * @return
     */
    public PedidoResponse guardarPedido(PedidoRequest pedidoRequest) {
        Pedido pedido = this.pedidoMapper.toEntity(pedidoRequest);
        return this.pedidoMapper.toResponse(this.pedidoRepository.save(pedido));
    }

    /**
     * Actualiza un Pedido existente que encuentre por su id.
     *
     * @param id
     * @param pedidoRequest
     * @return
     */
    public PedidoResponse actualizaPedido(String id, PedidoRequest pedidoRequest) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new ObjetoNoEncontradoException(id));
        pedido.setEstatusPedido(pedidoRequest.estatusPedido());
        pedido.setCantidad(pedidoRequest.cantidad());
        pedido.setCanalDeVenta(pedidoRequest.canalDeVenta());
        return this.pedidoMapper.toResponse(this.pedidoRepository.save(pedido));
    }

    /**
     * Recupera una lista con todos los pedidos desde el repositorio.
     *
     * @return
     */
    public List<PedidoResponse> obtenerPedidos() {
        return this.pedidoMapper.toResponseList(this.pedidoRepository.findAll());
    }

    /**
     * Recupera un pedido desde el Repositorio, en caso de que no exista lanza una excepción.
     *
     * @param id
     * @return
     */
    public PedidoResponse obtenerPedidoPorId(String id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new ObjetoNoEncontradoException(id));
        return this.pedidoMapper.toResponse(pedido);
    }

    /**
     * Borra un Pedido del Repositorio.
     *
     * @param id
     */
    public void borrarPedido(String id) {
        this.pedidoRepository.deleteById(id);
    }
}

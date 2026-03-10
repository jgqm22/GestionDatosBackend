package com.liver.gil.gestionpedidos.cliente.application.service;

import com.liver.gil.gestionpedidos.cliente.api.dto.ClienteConPedidosResponse;
import com.liver.gil.gestionpedidos.cliente.api.dto.ClienteRequest;
import com.liver.gil.gestionpedidos.cliente.api.dto.ClienteResponse;
import com.liver.gil.gestionpedidos.cliente.api.dto.PedidosDelClienteResponse;
import com.liver.gil.gestionpedidos.cliente.application.mapper.ClienteMapper;
import com.liver.gil.gestionpedidos.cliente.domain.model.Cliente;
import com.liver.gil.gestionpedidos.cliente.infraestructure.client.PedidosDelClienteRestClient;
import com.liver.gil.gestionpedidos.cliente.infraestructure.repository.ClienteRepository;
import com.liver.gil.gestionpedidos.common.exception.ObjetoNoEncontradoException;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service para gestionar lo relativo al Cliente usando el Repository correspondiente.
 */
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;
    private final PedidosDelClienteRestClient pedidosDelClienteRestClient;

    /**
     * Constructor.
     *
     * @param clienteRepository
     * @param clienteMapper
     */
    public ClienteService(ClienteRepository clienteRepository,
                          ClienteMapper clienteMapper,
                          PedidosDelClienteRestClient pedidosDelClienteRestClient) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
        this.pedidosDelClienteRestClient = pedidosDelClienteRestClient;
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
    public List<ClienteConPedidosResponse> obtenerClientes() {
        List<Cliente> clientes = this.clienteRepository.findAll();

        List<ClienteConPedidosResponse> clientesConPedidos = null;
        if(clientes != null && !clientes.isEmpty()){

            //recupero todos los pedidos
            List<PedidosDelClienteResponse> todosLosPedidos = this.pedidosDelClienteRestClient.obtenerPedidosCliente();

            clientesConPedidos = clientes
                    .stream()
                    .map( cliente -> creaClienteConPedidosResponse(todosLosPedidos, cliente) )
                    .toList();
        }

        return clientesConPedidos;
    }

    /**
     * Recupera un cliente desde el Repositorio, en caso de que no exista lanza una excepción.
     *
     * @param id
     * @return
     */
    public ClienteConPedidosResponse obtenerClientePorId(String id) {
        //recupero el cliente...
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ObjetoNoEncontradoException(id));

        //recupero todos los pedidos
        List<PedidosDelClienteResponse> todosLosPedidos = this.pedidosDelClienteRestClient.obtenerPedidosCliente();

        return creaClienteConPedidosResponse(todosLosPedidos, cliente);
    }

    /**
     * Recupera solos los pedidos del cliente actual...
     * @param todosLosPedidos
     * @param cliente
     * @return
     */
    private static @NonNull ClienteConPedidosResponse creaClienteConPedidosResponse(
            List<PedidosDelClienteResponse> todosLosPedidos, Cliente cliente) {
        //filtro solo los pedidos del cliente actual, ya que el servicio no tiene una búsqueda de pedidos por id del cliente...
        List<PedidosDelClienteResponse> pedidosFiltrados = null;
        if(todosLosPedidos != null && !todosLosPedidos.isEmpty()) {
            pedidosFiltrados = todosLosPedidos
                    .stream()
                    .filter( pedido -> cliente.getUserId().equals( pedido.userId()))
                    .toList();
        }

        //creo el response ya con la información de los pedidos del cliente
        return new ClienteConPedidosResponse(
                cliente.getUserId(),
                cliente.getNombre(),
                cliente.getApellidoPaterno(),
                cliente.getApellidoMaterno(),
                cliente.getCorreoElectronico(),
                pedidosFiltrados
        );
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

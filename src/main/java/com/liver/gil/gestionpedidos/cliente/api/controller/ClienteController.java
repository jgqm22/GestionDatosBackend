
package com.liver.gil.gestionpedidos.cliente.api.controller;

import com.liver.gil.gestionpedidos.cliente.api.dto.ClienteRequest;
import com.liver.gil.gestionpedidos.cliente.api.dto.ClienteResponse;
import com.liver.gil.gestionpedidos.cliente.application.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/clientes")
@Tag(name = "Clientes V1", description = "API para la gestión de clientes - V1")
public class ClienteController {

    private final ClienteService clienteService;

    /**
     * Constructor.
     *
     * @param clienteService
     */
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    /**
     * Obtiene una lista de los Clientes registrados.
     *
     * @return
     */
    @Operation(summary = "Obtiene una lista de los Clientes registrados.")
    @GetMapping
    public List<ClienteResponse> obtenerClientes() {
        return this.clienteService.obtenerClientes();
    }

    /**
     * Obtiene un Cliente a partir de su id.
     *
     * @param id
     * @return
     */
    @Operation(summary = "Obtiene un Cliente a partir de su id.")
    @GetMapping("/{id}")
    public ClienteResponse obtenerCliente(@PathVariable String id) {
        return this.clienteService.obtenerClientePorId(id);
    }

    /**
     * Guarda la información de un Cliente.
     *
     * @param cliente
     * @return
     */
    @Operation(summary = "Guarda la información de un Cliente.")
    @PostMapping
    public ClienteResponse crearCliente(@RequestBody ClienteRequest cliente) {
        return this.clienteService.guardarCliente(cliente);
    }

    /**
     * Actualiza todos los datos de un cliente identificado por su id.
     *
     * @param id
     * @param clienteRequest
     * @return
     */
    @Operation(summary = "Actualiza todos los datos de un cliente identificado por su id.")
    @PutMapping("/{id}")
    public ClienteResponse actualizarCliente(@PathVariable String id, @RequestBody ClienteRequest clienteRequest) {
        return this.clienteService.actualizaCliente(id, clienteRequest);
    }

    /**
     * Borra un cliente identificado por su id.
     *
     * @param id
     */
    @Operation(summary = "Borra un cliente identificado por su id.")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        this.clienteService.borrarCliente(id);
    }

}

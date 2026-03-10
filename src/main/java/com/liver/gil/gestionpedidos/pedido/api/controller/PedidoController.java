package com.liver.gil.gestionpedidos.pedido.api.controller;

import com.liver.gil.gestionpedidos.pedido.api.dto.PedidoRequest;
import com.liver.gil.gestionpedidos.pedido.api.dto.PedidoResponse;
import com.liver.gil.gestionpedidos.pedido.application.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/pedidos")
@Tag(name = "Pedidos V1", description = "API para la gestión de pedidos - V1")
public class PedidoController {

    private final PedidoService pedidoService;

    /**
     * Constructor.
     *
     * @param pedidoService
     */
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    /**
     * Obtiene una lista de los Pedidos registrados.
     *
     * @return
     */
    @Operation(summary = "Obtiene una lista de los Pedidos registrados.")
    @GetMapping
    public List<PedidoResponse> obtenerPedidos() {
        return this.pedidoService.obtenerPedidos();
    }

    /**
     * Obtiene un Pedido a partir de su id.
     *
     * @param id
     * @return
     */
    @Operation(summary = "Obtiene un Pedido a partir de su id.")
    @GetMapping("/{id}")
    public PedidoResponse obtenerPedido(@PathVariable String id) {
        return this.pedidoService.obtenerPedidoPorId(id);
    }

    /**
     * Guarda la información de un Pedido.
     *
     * @param pedido
     * @return
     */
    @Operation(summary = "Guarda la información de un Pedido.")
    @PostMapping
    public PedidoResponse crearPedido(@RequestBody PedidoRequest pedido) {
        return this.pedidoService.guardarPedido(pedido);
    }

    /**
     * Actualiza todos los datos de un pedido identificado por su id.
     *
     * @param id
     * @param pedidoRequest
     * @return
     */
    @Operation(summary = "Actualiza todos los datos de un pedido identificado por su id.")
    @PutMapping("/{id}")
    public PedidoResponse actualizarPedido(@PathVariable String id, @RequestBody PedidoRequest pedidoRequest) {
        return this.pedidoService.actualizaPedido(id, pedidoRequest);
    }

    /**
     * Borra un pedido identificado por su id.
     *
     * @param id
     */
    @Operation(summary = "Borra un pedido identificado por su id.")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        this.pedidoService.borrarPedido(id);
    }
    
}

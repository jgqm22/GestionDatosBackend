package com.liver.gil.gestionpedidos.entrega.api.controller;

import com.liver.gil.gestionpedidos.entrega.api.dto.EntregaRequest;
import com.liver.gil.gestionpedidos.entrega.api.dto.EntregaResponse;
import com.liver.gil.gestionpedidos.entrega.application.service.EntregaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/entregas")
@Tag(name = "Entregas V1", description = "API para la gestión de entregas - V1")
public class EntregaController {

    private final EntregaService entregaService;

    /**
     * Constructor.
     *
     * @param entregaService
     */
    public EntregaController(EntregaService entregaService) {
        this.entregaService = entregaService;
    }

    /**
     * Obtiene una lista de las Entregas registradas.
     *
     * @return
     */
    @Operation(summary = "Obtiene una lista de las Entregas registradas.")
    @GetMapping
    public List<EntregaResponse> obtenerEntregas() {
        return this.entregaService.obtenerEntregas();
    }

    /**
     * Obtiene una Entrega a partir de su id.
     *
     * @param id
     * @return
     */
    @Operation(summary = "Obtiene una Entrega a partir de su id.")
    @GetMapping("/{id}")
    public EntregaResponse obtenerEntrega(@PathVariable String id) {
        return this.entregaService.obtenerEntregaPorId(id);
    }

    /**
     * Guarda la información de una Entrega.
     *
     * @param entrega
     * @return
     */
    @Operation(summary = "Guarda la información de una Entrega.")
    @PostMapping
    public EntregaResponse crearEntrega(@RequestBody EntregaRequest entrega) {
        return this.entregaService.guardarEntrega(entrega);
    }

    /**
     * Actualiza todos los datos de una entrega identificada por su id.
     *
     * @param id
     * @param entregaRequest
     * @return
     */
    @Operation(summary = "Actualiza todos los datos de una entrega identificado por su id.")
    @PutMapping("/{id}")
    public EntregaResponse actualizarEntrega(@PathVariable String id, @RequestBody EntregaRequest entregaRequest) {
        return this.entregaService.actualizaEntrega(id, entregaRequest);
    }

    /**
     * Borra una entrega identificada por su id.
     *
     * @param id
     */
    @Operation(summary = "Borra un entrega identificado por su id.")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        this.entregaService.borrarEntrega(id);
    }    

}

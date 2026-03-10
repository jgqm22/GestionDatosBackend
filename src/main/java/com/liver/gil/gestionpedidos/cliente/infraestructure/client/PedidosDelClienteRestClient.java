package com.liver.gil.gestionpedidos.cliente.infraestructure.client;

import com.liver.gil.gestionpedidos.cliente.api.dto.PedidosDelClienteResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;

/**
 * Cliente REST para recuperar los Pedidos del Cliente.
 */
@Component
public class PedidosDelClienteRestClient {

    private final RestClient restClient;

    /**
     * Constructor.
     * @param builder
     */
    public PedidosDelClienteRestClient(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://6994a4eab081bc23e9c0f61e.mockapi.io/api/v1/pedidos")
                .build();
    }

    /**
     * Recupera la lista de los Pedidos de los clientes.
     *
     * @return
     */
    public List<PedidosDelClienteResponse> obtenerPedidosCliente() {
        return restClient.get()
                .uri("/")
                .retrieve()
                .body(new ParameterizedTypeReference<List<PedidosDelClienteResponse>>() {});
    }

}

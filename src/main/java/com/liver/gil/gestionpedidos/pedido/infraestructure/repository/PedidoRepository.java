package com.liver.gil.gestionpedidos.pedido.infraestructure.repository;

import com.liver.gil.gestionpedidos.pedido.domain.model.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository para gestionar los Pedidos en MongoDB.
 */
public interface PedidoRepository extends MongoRepository<Pedido, String> {

}

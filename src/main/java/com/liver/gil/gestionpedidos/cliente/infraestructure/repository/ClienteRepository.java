package com.liver.gil.gestionpedidos.cliente.infraestructure.repository;

import com.liver.gil.gestionpedidos.cliente.domain.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository para gestionar los Clientes en MongoDB.
 */
public interface ClienteRepository extends MongoRepository<Cliente, String> {

}

package com.liver.gil.gestionpedidos.entrega.infraestructure.repository;

import com.liver.gil.gestionpedidos.entrega.domain.model.Entrega;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository para gestionar las Entregas en MongoDB.
 */
public interface EntregaRepository extends MongoRepository<Entrega, String> {
    
}


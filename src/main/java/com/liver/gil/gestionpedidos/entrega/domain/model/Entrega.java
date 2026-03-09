package com.liver.gil.gestionpedidos.entrega.domain.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Entity que representa una Entrega.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "entrega")
public class Entrega {

    @Id
    private String id;
    private String calle;
    private String ciudad;
    private String codigoPostal;
}

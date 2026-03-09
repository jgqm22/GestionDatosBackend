package com.liver.gil.gestionpedidos.common.exception;

public class ObjetoNoEncontradoException extends RuntimeException {

    public ObjetoNoEncontradoException(String id) {
        super("Objeto no encontrado con id: " + id);
    }

}
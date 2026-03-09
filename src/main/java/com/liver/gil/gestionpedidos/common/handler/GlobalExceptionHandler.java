package com.liver.gil.gestionpedidos.common.handler;

import com.liver.gil.gestionpedidos.common.dto.ErrorResponse;
import com.liver.gil.gestionpedidos.common.exception.ObjetoNoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObjetoNoEncontradoException.class)
    public ResponseEntity<ErrorResponse> handleClienteNotFound(
            ObjetoNoEncontradoException ex) {

        ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}

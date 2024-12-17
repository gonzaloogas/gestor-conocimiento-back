package com.getronics.gestor_conocimiento_back.controller;

import com.getronics.gestor_conocimiento_back.dto.ErrorDTO;
import com.getronics.gestor_conocimiento_back.exception.*;
import jakarta.persistence.ManyToOne;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ProfesionalNotFoundException.class)
    public ResponseEntity<ErrorDTO> profesionalNotFound(ProfesionalNotFoundException ex){
        ErrorDTO error = ErrorDTO.builder().code("P-500").message(ex.getMessage()).build();
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = HabilidadNotFoundException.class)
    public ResponseEntity<ErrorDTO> habilidadNotFound(HabilidadNotFoundException ex){
        ErrorDTO error = ErrorDTO.builder().code("P-501").message(ex.getMessage()).build();
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = IdiomaNotFoundException.class)
    public ResponseEntity<ErrorDTO> idiomaNotFound(IdiomaNotFoundException ex){
        ErrorDTO error = ErrorDTO.builder().code("P-502").message(ex.getMessage()).build();
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = FormacionAcademicaNotFoundException.class)
    public ResponseEntity<ErrorDTO> formacionNotFound(FormacionAcademicaNotFoundException ex){
        ErrorDTO error = ErrorDTO.builder().code("P-503").message(ex.getMessage()).build();
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ClienteNotFoundException.class)
    public ResponseEntity<ErrorDTO> clienteNotFound(ClienteNotFoundException ex){
        ErrorDTO error = ErrorDTO.builder().code("P-504").message(ex.getMessage()).build();
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String, Object> errores = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(
                error -> errores.put(error.getField(), error.getDefaultMessage()));

        return new ResponseEntity<>(errores,HttpStatus.BAD_REQUEST);
    }
}

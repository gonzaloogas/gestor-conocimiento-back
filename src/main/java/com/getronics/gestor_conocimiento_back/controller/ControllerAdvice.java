package com.getronics.gestor_conocimiento_back.controller;

import com.getronics.gestor_conocimiento_back.dto.ErrorDTO;
import com.getronics.gestor_conocimiento_back.exception.*;
import jakarta.persistence.ManyToOne;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
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

    @ExceptionHandler(value = DataAccessException.class)
    public ResponseEntity<ErrorDTO> ErrorBD(DataAccessException ex){
        ErrorDTO error = ErrorDTO.builder().code("P-404").message(ex.getMessage()).build();
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = DataNotFoundException.class)
    public ResponseEntity<ErrorDTO> dataNotFound(DataNotFoundException ex){
        ErrorDTO error = ErrorDTO.builder().code("P-400").message(ex.getMessage()).build();
        return new ResponseEntity<>(error,HttpStatus.CONFLICT);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String, Object> errores = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(
                error -> errores.put(error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(errores,HttpStatus.BAD_REQUEST);
    }
}
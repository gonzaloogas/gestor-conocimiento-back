package com.getronics.gestor_conocimiento_back.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hello-1")
    @PreAuthorize("hasRole('administrador_client_role')")
    public String helloAdmin(){
        return "Hello Spring Boot With Keycloak - ADMIN";
    }

    @GetMapping("/hello-2")
    @PreAuthorize("hasRole('operador_client_role') or hasRole('administrador_client_role')")
    public String helloOperador(){
        return "Hello Spring Boot With Keycloak - OPERADOR";
    }

    @GetMapping("/hello-3")
    @PreAuthorize("hasRole('profesional_client_role') or hasRole('administrador_client_role')")
    public String helloProfesional(){
        return "Hello Spring Boot With Keycloak - PROFESIONAL";
    }
}
package com.getronics.gestor_conocimiento_back.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Para buscar el nombre de la persona en el jwt
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

//logger
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class TestController {

    //logger
    private static final Logger logger =LogManager.getLogger(TestController.class);

    @GetMapping("/hello-1")
    @PreAuthorize("hasRole('administrador_client_role')")
    public String helloAdmin(){
        // Obtiene el nombre del usuario desde el JWT
        String name = getAuthenticatedUserNameFromJwt();
        logger.info("{} ingreso como ADMIN", name);
        return "Hello Spring Boot With Keycloak - ADMIN";
    }

    @GetMapping("/hello-2")
    @PreAuthorize("hasRole('operador_client_role') or hasRole('administrador_client_role')")
    public String helloOperador(){
        String name = getAuthenticatedUserNameFromJwt();
        logger.info("{} ingreso como OPERADOR", name);
        return "Hello Spring Boot With Keycloak - OPERADOR";
    }

    @GetMapping("/hello-3")
    @PreAuthorize("hasRole('profesional_client_role') or hasRole('administrador_client_role')")
    public String helloProfesional(){
        String name = getAuthenticatedUserNameFromJwt();
        logger.info("{} ingreso como PROFESIONAL", name);
        return "Hello Spring Boot With Keycloak - PROFESIONAL";
    }


    //Para obtener el nombre del json autenticado
    private String getAuthenticatedUserNameFromJwt() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof Jwt) {
            Jwt jwt = (Jwt) authentication.getPrincipal();
            // Aquí se obtiene el claim "name" del JWT, si está disponible
            return jwt.getClaim("name");  // Usa el nombre del claim que contiene el nombre real del usuario
        }
        return "Desconocido";
    }

}
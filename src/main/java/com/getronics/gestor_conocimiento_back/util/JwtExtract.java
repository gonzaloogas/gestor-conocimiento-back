package com.getronics.gestor_conocimiento_back.util;
/*
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.oauth2.jwt.Jwt;
//import org.springframework.stereotype.Component;

import org.springframework.stereotype.Component;

@Component
public class JwtExtract {

    public String getAuthenticatedUserNameFromJwt(String nameClaime){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof Jwt) {
            Jwt jwt = (Jwt) authentication.getPrincipal();
            // Aquí se obtiene el claim "name" del JWT, si está disponible
            return jwt.getClaim(nameClaime);  // Usa el nombre del claim que contiene el nombre real del usuario
        }
        return "Sin informacion";
    }
}
*/
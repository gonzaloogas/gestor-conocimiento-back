package com.getronics.gestor_conocimiento_back.config;
/*
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimNames;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Component
public class JwtAuthenticationConverter implements Converter <Jwt, AbstractAuthenticationToken>{

    private final JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();

    @Value("${jwt.auth.converter.principle-attribute}")
    private String principleAtrribute;

    @Value("${jwt.auth.converter.resource-id}")
    private String resourceId;

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {

        //Aca se extraen los nombres de los roles que tiene
        Collection<GrantedAuthority> authorities = Stream
                .concat(jwtGrantedAuthoritiesConverter.convert(jwt).stream(), extractResourceRoles(jwt).stream())
                .toList();

        return new JwtAuthenticationToken(jwt, authorities, getPrincipleName(jwt));
    }


    private Collection<? extends GrantedAuthority> extractResourceRoles(Jwt jwt){

        Map<String, Object> resourceAccess;
        Map<String, Object> resource;
        Collection<String> resourceRoles;

        //Si el recurso no existe, retorna una lista vacia
        if(jwt.getClaim("resource_access") == null){
            return List.of();

        }

        resourceAccess = jwt.getClaim("resource_access");

        if(resourceAccess.get(resourceId) == null){
            return List.of();
        }

        resource = (Map<String, Object>) resourceAccess.get(resourceId);

        if(resource.get("roles") == null){
            return List.of();
        }

        resourceRoles = (Collection<String>) resource.get("roles");

        //Se convierten los roles y se le coloca el prefijo ROLE_ y se retorna la lista
        return resourceRoles.stream().
                map(role -> new SimpleGrantedAuthority("ROLE_".concat(role)))
                .toList();

    }

    //se extrea el usuario, si no esta, retorna en id SUB
    private String getPrincipleName(Jwt jwt){
        //Esto es una constante
        String clainName = JwtClaimNames.SUB;

        if(principleAtrribute != null){
            clainName = principleAtrribute;
        }
        return jwt.getClaim(clainName);
    }
}

 */
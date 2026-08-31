package com.professionalit.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class JwtAuthConverter
        implements Converter<Jwt, AbstractAuthenticationToken> {

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        Map<String,Object> realm =
                jwt.getClaim("realm_access");

        if(realm!=null){

            List<String> roles =
                    (List<String>) realm.get("roles");

            if(roles!=null){

                roles.forEach(role->

                        authorities.add(
                                new SimpleGrantedAuthority(
                                        "ROLE_"+role)));

            }

        }

        return new JwtAuthenticationToken(jwt,authorities);

    }

}
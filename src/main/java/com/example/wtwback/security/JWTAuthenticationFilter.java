package com.example.wtwback.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.naming.AuthenticationException;
import java.io.IOException;
import java.util.Collections;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

    public Authentication attempAuthentication (HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException{

        AuthenCredentials authCredencials = new AuthenCredentials();

        try {
            authCredencials = new ObjectMapper().readValue(request. getReader(), AuthenCredentials.class);
        } catch (IOException e){

        }

        UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
                AuthenCredentials.getEmail(),
                AuthenCredentials.getPassword(),
                Collections.emptyList()

        );
        return AuthenticationManager().authenticate(usernamePAT);
    }

    @Override
    protected void succesfullAthentication(HttpServletRequest request,
                                           HttpServletResponse response,
                                           FilterChain chain,
                                           Authentication authResult) throws IOException, ServletException{

        UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();
        String token = TokenUtils.createToken(userDetails.getName(), userDetails.getUsername());

        response.addHeader("Authorization", "Bearer " + token);
        response.getWriter().flush();

        super.successfulAuthentication(request, response, chain, authResult);
    }
}

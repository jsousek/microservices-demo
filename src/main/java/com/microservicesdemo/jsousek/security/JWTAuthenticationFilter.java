package com.microservicesdemo.jsousek.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservicesdemo.jsousek.models.UserModel;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.microservicesdemo.jsousek.security.SecurityConstants.*;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            UserModel user = new ObjectMapper()
                    .readValue(req.getInputStream(), UserModel.class);

            return  authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getUsername(),
                            user.getPassword(),
                            new ArrayList<>())
            );
        }
        catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                           HttpServletResponse res,
                                           FilterChain chain,
                                           Authentication auth) throws IOException, ServletException {
    String token = JWT.create()
            .withSubject(((User)auth.getPrincipal()).getUsername())
            .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .sign(Algorithm.HMAC512(SECRET.getBytes()));

    res.addHeader(HEADER_STRING, appendToken(token));
    }

    private String appendToken(String token){
        StringBuilder sBuilder = new StringBuilder(TOKEN_PREFIX);
        return sBuilder.append(token).toString();
    }

}

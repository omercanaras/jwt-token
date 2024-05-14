package com.omercan.security.jwttoken.service;

import com.omercan.security.jwttoken.dto.AuthRequest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthService {

    private final UserService userService;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;


    public AuthService(UserService userService, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }


        public String createAuth(AuthRequest request)
        {
           Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(),request.password()));

            if(authentication.isAuthenticated())
            {
                return jwtService.generateToken(request.username());
            }
            log.info("invalid username " + request.username());
            throw new UsernameNotFoundException("Invalid username {}" + request.username());
        }

}

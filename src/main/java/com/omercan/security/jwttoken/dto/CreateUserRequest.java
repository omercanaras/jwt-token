package com.omercan.security.jwttoken.dto;

import com.omercan.security.jwttoken.model.Role;
import lombok.Builder;

import java.util.Set;

@Builder
public record CreateUserRequest(
        String name,
        String username,
        String password,
        Set<Role> authorities
){
}

package com.omercan.security.jwttoken.dto;

public record AuthRequest(
        String username,
        String password
) {
}

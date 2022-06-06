package com.practice.jwt1.global.security.jwt;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class JwtValidateService {

    private JwtTokenProvider jwtTokenProvider;

    public String getEmail(String token) {
        return jwtTokenProvider.extractAllClaims(token).getSubject();
    }
}

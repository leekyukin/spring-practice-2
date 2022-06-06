package com.practice.jwt1.global.security.jwt;

import com.practice.jwt1.global.security.auth.AuthDetailsService;
import com.practice.jwt1.global.utils.CookieUtil;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.practice.jwt1.global.security.jwt.JwtProperties.ACCESS_TOKEN_NAME;

@Component
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final CookieUtil cookieUtil;
    private final AuthDetailsService authDetailsService;
    private final JwtValidateService jwtValidateService;
    private final JwtTokenProvider jwtTokenProvider;

    public JwtAuthenticationFilter(
            CookieUtil cookieUtil,
            AuthDetailsService authDetailsService,
            JwtValidateService jwtValidateService,
            JwtTokenProvider jwtTokenProvider
    ) {
        this.cookieUtil = cookieUtil;
        this.authDetailsService = authDetailsService;
        this.jwtValidateService = jwtValidateService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        final Cookie accessTokenCookie =
                cookieUtil.getCookie(request, ACCESS_TOKEN_NAME);

        if (accessTokenCookie != null) {
            try {
                String accessToken = accessTokenCookie.getValue();
                log.error("cookie.getValue() : {}", accessToken);
                setAuthentication(accessToken, request);
            } catch (ExpiredJwtException e) {
                response.sendRedirect("/user/logout");
            }
        }
        filterChain.doFilter(request, response);
    }

    private void setAuthentication(String token, HttpServletRequest request) throws ExpiredJwtException {
        UserDetails userDetails
                = authDetailsService.loadUserByUsername(jwtValidateService.getEmail(token));

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
        );

        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}

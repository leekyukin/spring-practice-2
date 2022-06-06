package com.practice.jwt1.global.security;

import com.practice.jwt1.domain.user.domain.type.Authority;
import com.practice.jwt1.global.security.auth.AuthDetailsService;
import com.practice.jwt1.global.security.jwt.JwtAuthenticationFilter;
import com.practice.jwt1.global.security.jwt.JwtTokenProvider;
import com.practice.jwt1.global.security.jwt.JwtValidateService;
import com.practice.jwt1.global.utils.CookieUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthDetailsService authDetailsService;
    private final JwtValidateService jwtValidateService;
    private final CookieUtil cookieUtil;
    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder();}

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .httpBasic().disable()
                .csrf().disable()
                .formLogin().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                ;

        http
                .authorizeRequests()
                .antMatchers("/user/login", "/user").permitAll()
                .antMatchers("/user/check").hasRole(Authority.ROEL_USER.name())
                .anyRequest().authenticated()
        ;

        http
                .addFilterBefore(
                        new JwtAuthenticationFilter(
                                cookieUtil, authDetailsService, jwtValidateService, jwtTokenProvider
                        ),
                        UsernamePasswordAuthenticationFilter.class
                );
    }
}

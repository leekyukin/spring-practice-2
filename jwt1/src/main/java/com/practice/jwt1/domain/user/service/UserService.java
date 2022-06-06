package com.practice.jwt1.domain.user.service;

import com.practice.jwt1.domain.user.domain.User;
import com.practice.jwt1.domain.user.facade.UserFacade;
import com.practice.jwt1.domain.user.presentation.dto.request.CreateUserRequestDto;
import com.practice.jwt1.domain.user.presentation.dto.request.LoginRequestDto;
import com.practice.jwt1.domain.user.presentation.dto.response.TokenResponseDto;
import com.practice.jwt1.global.security.jwt.JwtProperties;
import com.practice.jwt1.global.security.jwt.JwtTokenProvider;
import com.practice.jwt1.global.utils.CookieUtil;
import com.practice.jwt1.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final CookieUtil cookieUtil;

    @Transactional
    public void signup(CreateUserRequestDto request) {
        userFacade.checkUser(request.getEmail());
        userRepository.save(request.toEntity(passwordEncoder.encode(request.getPassword())));
    }

    @Transactional(readOnly = true)
    public TokenResponseDto login(LoginRequestDto request, HttpServletResponse response) {
        User user = userFacade.findByEmail(request.getEmail());
        userFacade.checkUserPassword(user, request.getPassword());

        log.error("2. request.getEmail : {}", request.getEmail());
        final String accessToken = jwtTokenProvider.createAccessToken(request.getEmail());
        log.error("4. createAccessToken : {}", accessToken);
        Cookie accessTokenCookie = cookieUtil.createCookie(
                JwtProperties.ACCESS_TOKEN_NAME,
                accessToken,
                JwtProperties.ACCESS_TOKEN_VALID_TIME
        );
        log.error("5. createToken ->accessTokenCookie : {}", accessTokenCookie);
        response.addCookie(accessTokenCookie);
        return TokenResponseDto.builder()
                .accessToken(accessToken)
                .build();
    }
}

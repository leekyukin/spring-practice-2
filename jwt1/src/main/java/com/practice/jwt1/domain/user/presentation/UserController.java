package com.practice.jwt1.domain.user.presentation;

import com.practice.jwt1.domain.user.presentation.dto.request.CreateUserRequestDto;
import com.practice.jwt1.domain.user.presentation.dto.request.LoginRequestDto;
import com.practice.jwt1.domain.user.presentation.dto.response.TokenResponseDto;
import com.practice.jwt1.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping
    public void signup(
            @RequestBody CreateUserRequestDto request
    ) {
        log.error("request : {}", request);
        userService.signup(request);
    }

    @PostMapping("/login")
    public TokenResponseDto login(
            @RequestBody LoginRequestDto request,
            HttpServletResponse response
    ) {
        log.error("1. requst : {}", request);
        return userService.login(request, response);
    }

    @GetMapping("/check")
    public String check() {
        return "Your Token is Already Alive";
    }

}

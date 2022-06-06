package com.practice.jwt2.domain.user.presentation;

import com.practice.jwt2.domain.user.presentation.dto.request.CreateUserRequestDto;
import com.practice.jwt2.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/join")
    public void join(
            @RequestBody CreateUserRequestDto request
    ) {
        userService.join(request);
    }
}

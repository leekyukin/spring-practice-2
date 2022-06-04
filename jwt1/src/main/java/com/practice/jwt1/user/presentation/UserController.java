package com.practice.jwt1.user.presentation;

import com.practice.jwt1.user.presentation.dto.request.CreateUserRequestDto;
import com.practice.jwt1.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public void signup(
            @RequestBody CreateUserRequestDto request
    ) {
        userService.signup(request);
    }
}

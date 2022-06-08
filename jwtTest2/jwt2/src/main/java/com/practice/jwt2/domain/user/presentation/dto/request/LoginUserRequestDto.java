package com.practice.jwt2.domain.user.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class LoginUserRequestDto {
    private String email;
    private String password;
}

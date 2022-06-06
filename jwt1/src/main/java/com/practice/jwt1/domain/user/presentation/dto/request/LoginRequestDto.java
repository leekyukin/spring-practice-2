package com.practice.jwt1.domain.user.presentation.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class LoginRequestDto {

    private String email;
    private String password;
}

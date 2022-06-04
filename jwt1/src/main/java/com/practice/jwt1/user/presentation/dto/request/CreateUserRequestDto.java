package com.practice.jwt1.user.presentation.dto.request;

import com.practice.jwt1.user.domain.User;
import com.practice.jwt1.user.domain.type.Authority;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUserRequestDto {

    private String email;
    private String password;
    private String name;

    public static User toEntity(CreateUserRequestDto request) {
        return User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .name(request.getName())
                .authority(Authority.ROEL_USER)
                .build();
    }
}

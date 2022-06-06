package com.practice.jwt1.domain.user.presentation.dto.request;

import com.practice.jwt1.domain.user.domain.User;
import com.practice.jwt1.domain.user.domain.type.Authority;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUserRequestDto {

    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String name;

    public User toEntity(String password) {
        return User.builder()
                .email(email)
                .password(password)
                .name(name)
                .authority(Authority.ROEL_USER)
                .build();
    }
}

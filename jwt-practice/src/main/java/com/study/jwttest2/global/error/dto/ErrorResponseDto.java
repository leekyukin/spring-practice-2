package com.study.jwttest2.global.error.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ErrorResponseDto {

    private int status;
    private String message;
}

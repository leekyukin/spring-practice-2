package com.study.jwttest2.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(500, "서버에 오류 발생"),
    BAD_REQUEST(404, "잘못된 요청")
    ;

    private final int status;
    private final String message;
}

package com.practice.jwt1.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INTERNAL_SERVER_ERROR(500, "서버에 문제 발생"),
    BAD_REQUEST(400, "잘 못된 요청"),

    USER_NOT_FOUND(404, "사용자를 찾을 수 없음"),
    USER_ALREADY_EXISTS(422, "이미 존재하는 사용자 입니다."),
    PASSWORD_MISMATCH(401, "비밀번호가 일치하지 않습니다.")

    ;

    private final int status;
    private final String message;
}

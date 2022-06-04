package com.study.jwttest2.global.error.exception;

import lombok.Getter;

@Getter
public class StudyException extends RuntimeException {

    private final ErrorCode errorCode;
    private final String message;


    public StudyException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
    }

    public StudyException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }
}

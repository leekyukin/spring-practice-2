package com.practice.jwt1.global.error.exception;

import lombok.Getter;

@Getter
public class PracticeException extends RuntimeException {

    private final ErrorCode errorCode;
    private final String message;

    public PracticeException (ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }

    public PracticeException (ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
    }
}

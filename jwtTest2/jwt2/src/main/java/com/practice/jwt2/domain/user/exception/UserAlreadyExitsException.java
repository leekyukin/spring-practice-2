package com.practice.jwt2.domain.user.exception;

import com.practice.jwt2.global.error.exception.BusinessException;
import com.practice.jwt2.global.error.exception.ErrorCode;

public class UserAlreadyExitsException extends BusinessException {
    public static UserAlreadyExitsException EXCEPTION = new UserAlreadyExitsException();

    private UserAlreadyExitsException() {
        super(ErrorCode.USER_ALREADY_EXISTS);
    }
}

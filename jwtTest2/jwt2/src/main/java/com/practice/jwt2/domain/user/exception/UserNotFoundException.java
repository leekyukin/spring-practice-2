package com.practice.jwt2.domain.user.exception;

import com.practice.jwt2.global.error.exception.BusinessException;
import com.practice.jwt2.global.error.exception.ErrorCode;

public class UserNotFoundException extends BusinessException {
    public static UserNotFoundException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {super(ErrorCode.USER_NOT_FOUND);}
}

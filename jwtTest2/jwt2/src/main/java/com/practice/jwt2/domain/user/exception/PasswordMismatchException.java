package com.practice.jwt2.domain.user.exception;

import com.practice.jwt2.global.error.exception.BusinessException;
import com.practice.jwt2.global.error.exception.ErrorCode;

public class PasswordMismatchException extends BusinessException {
    public static PasswordMismatchException EXCEPTION = new PasswordMismatchException();

    private PasswordMismatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}

package com.practice.jwt1.domain.user.exception;

import com.practice.jwt1.global.error.exception.ErrorCode;
import com.practice.jwt1.global.error.exception.PracticeException;

public class PasswordMisMatchException extends PracticeException {
    public static PasswordMisMatchException EXCEPTION = new PasswordMisMatchException();

    private PasswordMisMatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}

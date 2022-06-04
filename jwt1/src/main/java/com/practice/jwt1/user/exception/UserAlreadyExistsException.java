package com.practice.jwt1.user.exception;

import com.practice.jwt1.global.error.exception.ErrorCode;
import com.practice.jwt1.global.error.exception.PracticeException;

public class UserAlreadyExistsException extends PracticeException {

    public static UserAlreadyExistsException EXCEPTION = new UserAlreadyExistsException();

    private UserAlreadyExistsException() { super(ErrorCode.USER_ALREADY_EXISTS);}
}

package com.practice.jwt1.domain.user.exception;


import com.practice.jwt1.global.error.exception.ErrorCode;
import com.practice.jwt1.global.error.exception.PracticeException;

public class UserNotFoundException extends PracticeException {

    public final static UserNotFoundException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {super(ErrorCode.USER_NOT_FOUND);}

}

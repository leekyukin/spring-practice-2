package com.practice.jwt1.global.error;

import com.practice.jwt1.global.error.exception.ErrorCode;
import com.practice.jwt1.global.error.exception.PracticeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class PracticeExceptionHandler {

    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(PracticeException.class)
    public ErrorResponseDto practiceExceptionHandler(PracticeException e, HttpServletRequest request) {
        log.error(
                "status : {}, url : {}, message : {}",
                e.getErrorCode().getStatus(), request.getRequestURI(), e.getMessage()
        );
        return ErrorResponseDto.builder()
                .status(e.getErrorCode().getStatus())
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(Exception.class)
    public ErrorResponseDto exceptionHandler(Exception e, HttpServletRequest request) {
        log.error(
                "url : {}, message : {}",
                request.getRequestURI(), e.getMessage()
        );
        return ErrorResponseDto.builder()
                .status(ErrorCode.INTERNAL_SERVER_ERROR.getStatus())
                .message(ErrorCode.INTERNAL_SERVER_ERROR.getMessage())
                .build();
    }
}

package com.practice.jwt2.global.error;

import com.practice.jwt2.global.error.exception.BusinessException;
import com.practice.jwt2.global.error.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
@Slf4j
public class BusinessExceptionHandler {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(BusinessException.class)
    public ErrorResponseDto handleBusinessException(BusinessException e, HttpServletRequest request) {
        log.error("status : {}, url : {}, message : {}"
                , e.getErrorCode().getStatus(), request.getRequestURL(),e.getMessage());

        return ErrorResponseDto.builder()
                .status(e.getErrorCode().getStatus())
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(Exception.class)
    public ErrorResponseDto handleException(Exception e, HttpServletRequest request) {
        log.error("url : {}, message : {}", request.getRequestURI(), e.getMessage());

        return ErrorResponseDto.builder()
                .status(ErrorCode.INTERNAL_SERVER_ERROR.getStatus())
                .message(ErrorCode.INTERNAL_SERVER_ERROR.getMessage())
                .build();
    }
}
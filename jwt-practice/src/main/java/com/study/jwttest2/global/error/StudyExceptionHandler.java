package com.study.jwttest2.global.error;

import com.study.jwttest2.global.error.dto.ErrorResponseDto;
import com.study.jwttest2.global.error.exception.ErrorCode;
import com.study.jwttest2.global.error.exception.StudyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class StudyExceptionHandler  {

    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(StudyException.class)
    public ErrorResponseDto handleStudyException(StudyException e, HttpServletRequest request) {
        log.error(
                "status : {}, url : {}, message : {}",
                e.getErrorCode().getStatus(), request.getRequestURI(), e.getMessage()
        );
        return ErrorResponseDto.builder()
                .status(e.getErrorCode().getStatus())
                .message(e.getMessage())
                .build();
    }

//    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponseDto handleException(Exception e, HttpServletRequest request) {
        log.error(
                " url : {}, message : {}",
                request.getRequestURI(), e.getMessage()
        );
        return ErrorResponseDto.builder()
                .status(ErrorCode.INTERNAL_SERVER_ERROR.getStatus())
                .message(ErrorCode.INTERNAL_SERVER_ERROR.getMessage())
                .build();
    }

}

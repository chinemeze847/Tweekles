package com.africa.teambox.tweekles.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationHandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> handleBadRequestException(NotFoundException e) {
        ApiError error = new ApiError(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        return new ResponseEntity<>(error, error.getHttpStatus());
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ApiError> handleBadRequestException(ForbiddenException e) {
        ApiError error = new ApiError(HttpStatus.FORBIDDEN, e.getLocalizedMessage());
        return new ResponseEntity<>(error, error.getHttpStatus());
    }

}

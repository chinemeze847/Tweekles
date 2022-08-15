package com.africa.teambox.tweekles.exception;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@RequiredArgsConstructor
public class ApiError {

    private final HttpStatus httpStatus;

    private final String message;
}

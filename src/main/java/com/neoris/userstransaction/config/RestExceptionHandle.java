package com.neoris.userstransaction.config;

import com.neoris.userstransaction.dto.ErrorMessageResponseDto;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class RestExceptionHandle {


    @ExceptionHandler(value = IllegalStateException.class)
    public ResponseEntity<ErrorMessageResponseDto> handleIllegalStateException(IllegalStateException illegalStateException){
        return new ResponseEntity(
                        ErrorMessageResponseDto.builder()
                            .message(illegalStateException.getMessage())
                            .time(LocalDateTime.now())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(value = EmptyResultDataAccessException.class)
    public ResponseEntity<ErrorMessageResponseDto> handleEmptyResultDataAccessException(EmptyResultDataAccessException emptyResultDataAccessException){
        return new ResponseEntity(
                ErrorMessageResponseDto.builder()
                        .message(emptyResultDataAccessException.getMessage())
                        .time(LocalDateTime.now())
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }
}

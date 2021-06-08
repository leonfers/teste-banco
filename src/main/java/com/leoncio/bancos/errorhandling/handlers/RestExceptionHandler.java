package com.leoncio.bancos.errorhandling.handlers;

import com.leoncio.bancos.errorhandling.exceptions.ItemNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice ("com.leoncio.bancos.controllers")
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    public static final String TRACE = "trace";

    @Override
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
                                                    MethodArgumentNotValidException ex,
                                                    HttpHeaders headers,
                                                    HttpStatus status,
                                                    WebRequest request
    ) {
       throw new UnsupportedOperationException();
    }


    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleItemNotFoundException(
            ItemNotFoundException itemNotFoundException,
            WebRequest request
    ){
        throw new UnsupportedOperationException();
    }


    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleAllUncaughtException(
            RuntimeException exception,
            WebRequest request
    ){
        throw new UnsupportedOperationException();
    }

}

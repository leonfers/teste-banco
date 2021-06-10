package com.leoncio.bancos.errorhandling.handlers;

import com.leoncio.bancos.dto.ErrorDTO;
import com.leoncio.bancos.dto.Response;
import com.leoncio.bancos.errorhandling.exceptions.DuplicateFoundException;
import com.leoncio.bancos.errorhandling.exceptions.IllegalTransactionException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice("com.leoncio.bancos.controllers")
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    public static final String TRACE = "trace";

    @Override
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        List<ErrorDTO> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setCode(status.value());
            errorDTO.setTitle(error.getField());
            errorDTO.setDetail(error.getDefaultMessage());
            errorDTO.setPath(((ServletWebRequest) request).getRequest().getRequestURL().toString());
            errorDTO.setTimestamp(LocalDateTime.now());
            errors.add(errorDTO);
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setCode(status.value());
            errorDTO.setTitle(error.getDefaultMessage());
            errorDTO.setDetail(error.getDefaultMessage());
            errorDTO.setPath(((ServletWebRequest) request).getRequest().getRequestURL().toString());
            errorDTO.setTimestamp(LocalDateTime.now());
            errors.add(errorDTO);
        }
        Response response = new Response();
        response.setErrors(errors);
        return handleExceptionInternal(
                ex, response, headers, status, request);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalTransactionException.class)
    protected ResponseEntity<Object> handleIllegalTransactionException(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        List<ErrorDTO> errors = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setCode(status.value());
            errorDTO.setTitle(error.getDefaultMessage());
            errorDTO.setDetail(error.getDefaultMessage());
            errorDTO.setPath(((ServletWebRequest) request).getRequest().getRequestURL().toString());
            errorDTO.setTimestamp(LocalDateTime.now());
            errors.add(errorDTO);
        }
        Response response = new Response();
        response.setErrors(errors);
        return handleExceptionInternal(
                ex, response, headers, status, request);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DuplicateFoundException.class)
    protected ResponseEntity<Object> handleDuplicateFoundException(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        List<ErrorDTO> errors = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setCode(status.value());
            errorDTO.setTitle(error.getDefaultMessage());
            errorDTO.setDetail(error.getDefaultMessage());
            errorDTO.setPath(((ServletWebRequest) request).getRequest().getRequestURL().toString());
            errorDTO.setTimestamp(LocalDateTime.now());
            errors.add(errorDTO);
        }
        Response response = new Response();
        response.setErrors(errors);
        return handleExceptionInternal(
                ex, response, headers, status, request);
    }


    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleAllUncaughtException(
            RuntimeException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request
    ) {
        List<ErrorDTO> errors = new ArrayList<>();
        Response response = new Response();
        response.setErrors(errors);

        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setCode(500);
        errorDTO.setTitle("Unknown error");
        errorDTO.setDetail("An error occurred at our servers, rest assured that our team will deal with it as soon as possible!");
        errorDTO.setPath(((ServletWebRequest) request).getRequest().getRequestURL().toString());
        errorDTO.setTimestamp(LocalDateTime.now());
        errors.add(errorDTO);
        return handleExceptionInternal(
                ex, response, headers, status, request);
    }

}

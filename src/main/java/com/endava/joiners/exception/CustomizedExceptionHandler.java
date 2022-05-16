package com.endava.joiners.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.util.Date;

@ControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
        return new ResponseEntity<Object>(new ErrorMessage("Internal server error", new Date()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({JoinerNotFoundException.class})
    public final ResponseEntity<Object> handleJoinerNotFoundException(Exception ex, WebRequest request) throws Exception {
        /*if(ex.getClass().getName().contains("EmptyResultDataAccessException")){
            return new ResponseEntity<Object>(new ErrorMessage("Joiner not found", new Date()), HttpStatus.NOT_FOUND);
        }*/
        return new ResponseEntity<Object>(new ErrorMessage(ex.getMessage(), new Date()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public final ResponseEntity<Object> duplicatedKeyException(Exception ex, WebRequest request) throws Exception {
        System.out.println("data integrity");
        return new ResponseEntity<Object>(new ErrorMessage("Joiner already exists", new Date()), HttpStatus.CONFLICT);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Throwable cause = ex.getCause();

        if( cause instanceof  InvalidFormatException) {
            return new ResponseEntity<Object>(new ErrorMessage( "Invalid format",new Date()), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Object>(new ErrorMessage( "Cannot deserialize object",new Date()), HttpStatus.BAD_REQUEST);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>(new ErrorMessage( "Bad request",new Date()), HttpStatus.BAD_REQUEST);
    }
}

package com.endava.joiners.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class JoinerNotFoundException extends RuntimeException {

    public JoinerNotFoundException(String message){
        super(message);
    }
}

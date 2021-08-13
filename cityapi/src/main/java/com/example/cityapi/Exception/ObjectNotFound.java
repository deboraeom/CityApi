package com.example.cityapi.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ObjectNotFound extends Exception{
    public ObjectNotFound(String message, Long id) {
        super(message + " com o id " + "not found");
    }
}

package com.alcancia.demoalcancia.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionGlobalResponse {

    public static final String MESSAGEEXEPTION = "Exception: ";

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> runtimeException(RuntimeException e) {
        String message = e.getMessage();
        Map<String, Object> map = new HashMap<>();
        map.put("mensaje", message);
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

}

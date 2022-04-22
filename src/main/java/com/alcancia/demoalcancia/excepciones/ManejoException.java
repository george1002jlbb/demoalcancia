package com.alcancia.demoalcancia.excepciones;

public class ManejoException extends RuntimeException{

    public ManejoException(String message) {
        super(message);
    }

    public ManejoException(String message, Throwable cause) {
        super(message, cause);
    }
}

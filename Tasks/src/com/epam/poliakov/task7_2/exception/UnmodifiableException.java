package com.epam.poliakov.task7_2.exception;

public class UnmodifiableException extends IllegalStateException {

    public UnmodifiableException() {
    }

    public UnmodifiableException(String message){
        super(message);
    }
}

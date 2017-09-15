package com.epam.poliakov.task2.exception;

public class UnmodifiableException extends IndexOutOfBoundsException {

    public UnmodifiableException() {
    }

    public UnmodifiableException(String message){
        super(message);
    }
}

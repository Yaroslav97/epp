package com.epam.poliakov.util.exception;

public class DAOException extends RuntimeException {

    public DAOException() {
    }

    public DAOException(String message) {
        super(message);
    }
}

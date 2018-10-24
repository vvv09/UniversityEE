package com.valunskii.foxminded.university.repository.exception;

@SuppressWarnings("serial")
public class DAOException extends Exception {
    public DAOException(String message,Throwable throwable) {
        super(message, throwable);
    }
}

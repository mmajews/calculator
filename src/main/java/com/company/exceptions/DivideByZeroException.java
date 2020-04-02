package com.company.exceptions;

/**
 * This exception is being thrown when user tries to divide by 0
 */
public class DivideByZeroException extends RuntimeException {
    public DivideByZeroException(String message) {
        super(message);
    }
}

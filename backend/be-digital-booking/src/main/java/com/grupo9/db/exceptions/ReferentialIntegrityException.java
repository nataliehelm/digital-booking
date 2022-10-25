package com.grupo9.db.exceptions;

public class ReferentialIntegrityException extends Exception{
    public ReferentialIntegrityException(String message) {
        super(message);
    }
}

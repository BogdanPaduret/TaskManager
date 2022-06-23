package com.company.exceptions;

public class ElementExistsException extends RuntimeException {
    public ElementExistsException(String message) {
        super(message);
    }

    public ElementExistsException() {
        this("Inserted data already exists in list!");
    }

}

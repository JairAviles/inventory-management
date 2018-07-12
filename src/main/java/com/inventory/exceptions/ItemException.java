package com.inventory.exceptions;

public class ItemException extends RuntimeException {

    public ItemException(Throwable e) {
        super(e);
    }

    public ItemException(String message) {
        super(message);
    }
}

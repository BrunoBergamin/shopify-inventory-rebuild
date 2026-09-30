package com.bruno.inventory.exception;

public class InvalidShipmentStateException extends RuntimeException {
    public InvalidShipmentStateException(String message) {
        super(message);
    }
}

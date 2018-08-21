package com.bonappetit.app.errors;

public class OrderUserNotFoundException extends Exception {
    public OrderUserNotFoundException(String message) {
        super(message);
    }
}

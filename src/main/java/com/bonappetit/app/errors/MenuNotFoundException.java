package com.bonappetit.app.errors;

public class MenuNotFoundException extends Exception {
    public MenuNotFoundException(String message) {
        super(message);
    }
}
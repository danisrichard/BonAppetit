package com.bonappetit.app.errors;

public class DailyMenuNotFoundException extends Exception {
    public DailyMenuNotFoundException(String message) {
        super(message);
    }
}

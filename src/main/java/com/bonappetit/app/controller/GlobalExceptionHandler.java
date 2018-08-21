package com.bonappetit.app.controller;

import com.bonappetit.app.errors.DailyMenuNotFoundException;
import com.bonappetit.app.errors.MenuNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MenuNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleMenuNot(final MenuNotFoundException menuNotFoundExp, Model model) {
        return "order-page-section/order-page-main";
    }

    @ExceptionHandler(DailyMenuNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleDailyMenuNotFound(final DailyMenuNotFoundException menuNotFoundExp, Model model) {
        return "check-out-section/check-out-index";
    }
}

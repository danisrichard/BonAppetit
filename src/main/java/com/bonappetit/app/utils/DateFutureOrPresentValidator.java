package com.bonappetit.app.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.bonappetit.app.utils.LocalDateConverter.stringToLocalDateTime;


public class DateFutureOrPresentValidator implements ConstraintValidator<DateFutureOrPresentConstraint, String> {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public void initialize(DateFutureOrPresentConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String stringDate, ConstraintValidatorContext constraintValidatorContext) {
        LocalDateTime inputDate = stringToLocalDateTime(stringDate);
        String now = LocalDateTime.now().format(formatter);
        LocalDateTime nowDate = stringToLocalDateTime(now);
        return inputDate.isAfter(nowDate) || inputDate.isEqual(nowDate);
    }
}

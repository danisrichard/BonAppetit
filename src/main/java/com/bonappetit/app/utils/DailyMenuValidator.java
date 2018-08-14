package com.bonappetit.app.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DailyMenuValidator implements ConstraintValidator<DailyMenuFoodConstraint, String> {

    @Override
    public boolean isValid(String foodField, ConstraintValidatorContext constraintValidatorContext) {
        return foodField != null && !foodField.equals("") && (foodField.length() > 3);
    }

    @Override
    public void initialize(DailyMenuFoodConstraint constraintAnnotation) {
    }
}

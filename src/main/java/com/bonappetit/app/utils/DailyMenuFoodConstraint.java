package com.bonappetit.app.utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DailyMenuValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface DailyMenuFoodConstraint {
    String message() default "Not null";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}


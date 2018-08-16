package com.bonappetit.app.utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateFutureOrPresentValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DateFutureOrPresentConstraint {
    String message() default "Not valid.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

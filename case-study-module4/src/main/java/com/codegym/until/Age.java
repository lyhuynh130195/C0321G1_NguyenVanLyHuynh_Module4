package com.codegym.until;

import com.codegym.until.impl.AgeValidator;
import com.codegym.until.impl.UniqueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = AgeValidator.class)
@Documented
public @interface Age {
    String message() default "Age must be more than 18";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

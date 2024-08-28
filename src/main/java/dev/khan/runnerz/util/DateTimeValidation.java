package dev.khan.runnerz.util;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RunDateValidator.class)
public @interface DateTimeValidation {
    String[] dateTimes();

    String message() default "Completed On must be after the Started On";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

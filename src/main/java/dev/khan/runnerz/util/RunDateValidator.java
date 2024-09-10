package dev.khan.runnerz.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Stream;

public class RunDateValidator implements ConstraintValidator<DateTimeValidation,Object> {
    private static final SpelExpressionParser PARSER = new SpelExpressionParser();
    private String[] dateTimeFields;

    @Override
    public void initialize(DateTimeValidation constraintAnnotation) {
        dateTimeFields = constraintAnnotation.dateTimes();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
          return Boolean.parseBoolean(Stream.of(dateTimeFields).reduce((dateTime1, dateTime2) -> {
            LocalDateTime value1 = (LocalDateTime) PARSER.parseExpression(dateTime1).getValue(o);
            LocalDateTime value2 = (LocalDateTime) PARSER.parseExpression(dateTime2).getValue(o);
            if(value1!= null && value2!= null && !value1.isAfter(value2)){
                return String.valueOf(true);
            }
            return String.valueOf(false);
        }).get());
    }
}

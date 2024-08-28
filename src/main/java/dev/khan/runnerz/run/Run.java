package dev.khan.runnerz.run;

import dev.khan.runnerz.util.DateTimeValidation;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

@DateTimeValidation(dateTimes = {"startedOn", "completedOn"})
public record Run(
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive
        Integer kilometers,
        Location location
) {
}

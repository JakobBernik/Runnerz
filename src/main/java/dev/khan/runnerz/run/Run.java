package dev.khan.runnerz.run;

import dev.khan.runnerz.util.DateTimeValidation;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.time.LocalDateTime;

@DateTimeValidation(dateTimes = {"startedOn", "completedOn"})
public record Run(
        @Id
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

package suai.vladislav.onboardingapi.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import org.hibernate.validator.constraints.Range;

@Builder
public record ScoreboardDto(
    @Positive
    Long id,
    @Positive
    Integer score,
    @NotNull
    @Positive
    Long userId
) {
}

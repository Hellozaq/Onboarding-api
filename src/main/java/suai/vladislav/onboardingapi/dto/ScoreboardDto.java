package suai.vladislav.onboardingapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.hibernate.validator.constraints.Range;

@Builder
public record ScoreboardDto(
    Long id,
    @Range(min = 0)
    Integer score,
    @NotNull
    Long userId
) {
}

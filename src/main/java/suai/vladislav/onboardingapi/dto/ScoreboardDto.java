package suai.vladislav.onboardingapi.dto;

import lombok.Builder;
import lombok.Value;

@Builder
public record ScoreboardDto(
    Long id,
    Integer score,
    Long userId
) {
}

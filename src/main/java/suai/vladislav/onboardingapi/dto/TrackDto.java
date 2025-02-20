package suai.vladislav.onboardingapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record TrackDto(
    Long id,
    @NotBlank
    String name,
    @NotBlank
    Integer modulesCount
) {
}

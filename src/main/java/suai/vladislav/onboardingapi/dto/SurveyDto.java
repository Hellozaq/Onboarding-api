package suai.vladislav.onboardingapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record SurveyDto(
    @Positive
    Long id,

    @NotBlank
    String name,

    @NotBlank
    String content
) {
}

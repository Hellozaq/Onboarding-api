package suai.vladislav.onboardingapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record KnowledgeBaseDto(
    @Positive
    Long id,

    @NotBlank
    String name,

    @NotBlank
    String content
) {
}

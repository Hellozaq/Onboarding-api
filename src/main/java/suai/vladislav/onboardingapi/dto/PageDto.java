package suai.vladislav.onboardingapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PageDto(
    @Positive
    Long id,

    @NotBlank
    String content,

    @NotBlank
    String name,

    @Positive
    @NotNull
    Integer orderInModule,

    @Positive
    @NotNull
    Long moduleId
) {
}

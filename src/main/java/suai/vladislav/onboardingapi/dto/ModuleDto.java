package suai.vladislav.onboardingapi.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record ModuleDto(
    @Positive
    Long id,
    @NotBlank
    String name,
    @NotBlank
    String startContent,
    @NotBlank
    String endContent,
    @Positive
    Integer orderInTrack,
    Long trackId,
    @Positive
    Integer pagesCount
) {
}

package suai.vladislav.onboardingapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

import java.util.List;

@Builder
public record TrackDto(
    @Positive
    Long id,

    @NotBlank
    String name,

    List<ModuleDto> modules
) {
}

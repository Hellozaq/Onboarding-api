package suai.vladislav.onboardingapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.util.List;

@Builder
public record TrackDto(
    Long id,
    @NotBlank
    String name,
    List<ModuleDto> modules
) {
}

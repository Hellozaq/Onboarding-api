package suai.vladislav.onboardingapi.dto;

import lombok.Builder;

@Builder
public record ErrorDto(
    String message
) {
}

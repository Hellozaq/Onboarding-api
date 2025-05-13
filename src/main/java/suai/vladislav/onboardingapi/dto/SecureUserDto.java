package suai.vladislav.onboardingapi.dto;

import lombok.Builder;
import suai.vladislav.onboardingapi.enums.Role;

@Builder
public record SecureUserDto(
    Long id,
    String email,
    String firstName,
    String lastName,
    Role role
) {
}

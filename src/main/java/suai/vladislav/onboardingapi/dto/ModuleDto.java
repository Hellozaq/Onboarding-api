package suai.vladislav.onboardingapi.dto;


public record ModuleDto(
    Long id,
    String name,
    String startContent,
    String endContent,
    Integer orderInTrack,
    Long trackId
) {
}

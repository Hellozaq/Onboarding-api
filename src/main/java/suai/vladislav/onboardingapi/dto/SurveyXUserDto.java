package suai.vladislav.onboardingapi.dto;

import lombok.Builder;

@Builder
public record SurveyXUserDto (
    Long userId,
    Long surveyId
) {
}

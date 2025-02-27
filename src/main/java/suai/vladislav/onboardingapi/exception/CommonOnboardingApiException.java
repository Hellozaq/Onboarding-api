package suai.vladislav.onboardingapi.exception;

import lombok.Getter;
import suai.vladislav.onboardingapi.enums.ErrorType;

@Getter
public class CommonOnboardingApiException extends AbstractException {

    public CommonOnboardingApiException(ErrorType errorType, Object... params) {
        super(errorType, params);
    }

    public CommonOnboardingApiException(ErrorType errorType, Throwable ex, Object... params) {
        super(errorType, ex, params);
    }
}

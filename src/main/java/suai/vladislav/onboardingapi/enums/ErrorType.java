package suai.vladislav.onboardingapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {

    NOT_FOUND("Сущность не найдена, id=%s", HttpStatus.NOT_FOUND),
    ALREADY_EXISTS("Сущность уже существует, id=%s", HttpStatus.CONFLICT),
    WRONG_CREDENTIALS("Неверный логин или пароль", HttpStatus.UNAUTHORIZED);

    private final String message;
    private final HttpStatus status;
}

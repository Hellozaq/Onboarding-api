package suai.vladislav.onboardingapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {

    USER_NOT_FOUND("Пользовтель не найден, id=%s", HttpStatus.NOT_FOUND),
    SURVEY_NOT_FOUND("Опрос не найден, id=%s", HttpStatus.NOT_FOUND),
    KNOWLEDGE_BASE_NOT_FOUND("База знаний не найдена, id=%s", HttpStatus.NOT_FOUND),
    SCOREBOARD_NOT_FOUND("Таблица счета не найдена, id=%s", HttpStatus.NOT_FOUND),
    TRACK_NOT_FOUND("Трек не найден, id=%s", HttpStatus.NOT_FOUND),
    MODULE_NOT_FOUND("Модуль не найден, id=%s", HttpStatus.NOT_FOUND),
    PAGE_NOT_FOUND("Страница не найдена, id=%s", HttpStatus.NOT_FOUND),

    ALREADY_EXISTS("Сущность уже существует, id=%s", HttpStatus.CONFLICT),
    WRONG_CREDENTIALS("Неверный логин или пароль", HttpStatus.UNAUTHORIZED),
    ID_IS_MISSING("Не передан id сущности", HttpStatus.BAD_REQUEST);

    private final String message;
    private final HttpStatus status;
}

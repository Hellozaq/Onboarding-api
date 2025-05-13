package suai.vladislav.onboardingapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import suai.vladislav.onboardingapi.dto.SecureUserDto;
import suai.vladislav.onboardingapi.dto.SurveyXUserDto;
import suai.vladislav.onboardingapi.service.interfaces.SurveyXUserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class SurveyXUserController {

    private final SurveyXUserService surveyXUserService;

    @GetMapping("/surveys/{surveyId}/users")
    public List<SecureUserDto> getUsersForSurvey(
        @PathVariable("surveyId") Long surveyId
    ) {
        return surveyXUserService.getUsersForSurvey(surveyId);
    }

    @PostMapping("/surveys/{surveyId}/users/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public SurveyXUserDto addUserToSurvey(
        @PathVariable("surveyId") Long surveyId,
        @PathVariable("userId") Long userId
    ) {
        return surveyXUserService.addUserToSurvey(surveyId, userId);
    }

    @DeleteMapping("/surveys/{surveyId}/users/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserFromSurvey(
        @PathVariable("surveyId") Long surveyId,
        @PathVariable("userId") Long userId
    ) {
        surveyXUserService.deleteUserFromSurvey(surveyId, userId);
    }
}

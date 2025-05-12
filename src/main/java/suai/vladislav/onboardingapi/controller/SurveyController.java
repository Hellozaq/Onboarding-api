package suai.vladislav.onboardingapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import suai.vladislav.onboardingapi.dto.SurveyDto;
import suai.vladislav.onboardingapi.service.interfaces.SurveyService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/survey")
public class SurveyController {

    private final SurveyService surveyService;

    @GetMapping
    public List<SurveyDto> getSurveys() {
        return surveyService.getSurveys();
    }

    @GetMapping("/{surveyId}")
    public SurveyDto getSurvey(
        @PathVariable("surveyId") Long surveyId
    ) {
        return surveyService.getSurveyById(surveyId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SurveyDto addSurvey(
        @Validated
        @RequestBody SurveyDto surveyDto
    ) {
        return surveyService.addSurvey(surveyDto);
    }

    @PutMapping
    public SurveyDto updateSurvey(
        @Validated
        @RequestBody SurveyDto surveyDto
    ) {
        return surveyService.updateSurvey(surveyDto);
    }

    @DeleteMapping("/{surveyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSurvey(
        @Validated
        @PathVariable("surveyId") Long surveyId
    ) {
        surveyService.deleteSurvey(surveyId);
    }
}

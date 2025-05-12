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
import suai.vladislav.onboardingapi.dto.ScoreboardDto;
import suai.vladislav.onboardingapi.service.interfaces.ScoreboardService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/scoreboard")
public class ScoreboardController {

    private final ScoreboardService scoreboardService;

    @GetMapping
    public List<ScoreboardDto> getScoreboards() {
        return scoreboardService.getScoreboard();
    }

    @GetMapping("/{scoreboardId}")
    public ScoreboardDto getScoreboard(
        @PathVariable("scoreboardId") Long scoreboardId
    ) {
        return scoreboardService.getScoreboardById(scoreboardId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ScoreboardDto addScoreboard(@Validated @RequestBody ScoreboardDto scoreboardDto) {
        return scoreboardService.addScoreboard(scoreboardDto);
    }

    @PutMapping
    public ScoreboardDto updateScoreboard(@Validated @RequestBody ScoreboardDto scoreboardDto) {
        return scoreboardService.updateScoreboard(scoreboardDto);
    }

    @DeleteMapping("/{scoreboardId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteScoreboard(@Validated @PathVariable("scoreboardId") Long scoreboardId) {
        scoreboardService.deleteScoreboard(scoreboardId);
    }
}

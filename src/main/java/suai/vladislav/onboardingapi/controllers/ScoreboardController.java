package suai.vladislav.onboardingapi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import suai.vladislav.onboardingapi.dto.ScoreboardDto;
import suai.vladislav.onboardingapi.services.interfaces.ScoreboardService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScoreboardController {
    private final ScoreboardService scoreboardService;

    @GetMapping("/scoreboard")
    public List<ScoreboardDto> getScoreboard() {
        return scoreboardService.getScoreboard();
    }
}

package suai.vladislav.onboardingapi.service.interfaces;

import suai.vladislav.onboardingapi.dto.ScoreboardDto;

import java.util.List;

public interface ScoreboardService {
    List<ScoreboardDto> getScoreboard();
}

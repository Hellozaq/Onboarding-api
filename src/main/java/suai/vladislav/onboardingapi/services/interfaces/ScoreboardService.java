package suai.vladislav.onboardingapi.services.interfaces;

import suai.vladislav.onboardingapi.dto.ScoreboardDto;

import java.util.List;

public interface ScoreboardService {
    List<ScoreboardDto> getScoreboard();
}

package suai.vladislav.onboardingapi.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import suai.vladislav.onboardingapi.dto.ScoreboardDto;
import suai.vladislav.onboardingapi.repositories.ScoreboardRepository;
import suai.vladislav.onboardingapi.services.interfaces.ScoreboardService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScoreboardServiceImpl implements ScoreboardService {

    private final ScoreboardRepository scoreboardRepository;

    @Override
    public List<ScoreboardDto> getScoreboard() {
        return scoreboardRepository.findAll().stream()
            .map(scoreboard -> ScoreboardDto.builder()
                .id(scoreboard.getId())
                .score(scoreboard.getScore())
                .userId(scoreboard.getUser().getId())
                .build()
            )
            .toList();
    }
}

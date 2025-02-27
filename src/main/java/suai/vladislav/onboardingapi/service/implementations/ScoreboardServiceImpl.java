package suai.vladislav.onboardingapi.service.implementations;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import suai.vladislav.onboardingapi.dto.ScoreboardDto;
import suai.vladislav.onboardingapi.mapper.ScoreboardMapper;
import suai.vladislav.onboardingapi.repository.ScoreboardRepository;
import suai.vladislav.onboardingapi.service.interfaces.ScoreboardService;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScoreboardServiceImpl implements ScoreboardService {

    private final ScoreboardMapper scoreboardMapper;

    private final ScoreboardRepository scoreboardRepository;

    @Override
    public List<ScoreboardDto> getScoreboard() {
        log.info("вызван getScoreboard");

        return scoreboardRepository.findAll().stream()
            .map(scoreboardMapper::toDto)
            .toList();
    }
}

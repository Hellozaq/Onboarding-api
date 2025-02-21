package suai.vladislav.onboardingapi.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import suai.vladislav.onboardingapi.dto.TrackDto;
import suai.vladislav.onboardingapi.mappers.TrackMapper;
import suai.vladislav.onboardingapi.models.Track;
import suai.vladislav.onboardingapi.repositories.TrackRepository;
import suai.vladislav.onboardingapi.services.interfaces.TrackService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrackServiceImpl implements TrackService {

    private final TrackRepository trackRepository;

    private final TrackMapper trackMapper;

    @Override
    public List<TrackDto> getTracks() {
        return trackRepository.findAll().stream()
            .map(trackMapper::toDto)
            .toList();
    }

    @Override
    public TrackDto addTrack(TrackDto trackDto) {
        Track track = trackRepository.save(trackMapper.toModel(trackDto));

        return trackMapper.toDto(track);
    }
}

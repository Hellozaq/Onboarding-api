package suai.vladislav.onboardingapi.services.implementations;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import suai.vladislav.onboardingapi.dto.TrackDto;
import suai.vladislav.onboardingapi.enums.ErrorType;
import suai.vladislav.onboardingapi.exceptions.CommonOnboardingApiException;
import suai.vladislav.onboardingapi.mappers.TrackMapper;
import suai.vladislav.onboardingapi.models.Track;
import suai.vladislav.onboardingapi.repositories.TrackRepository;
import suai.vladislav.onboardingapi.services.interfaces.TrackService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TrackServiceImpl implements TrackService {

    private final TrackRepository trackRepository;

    private final TrackMapper trackMapper;

    @Override
    public List<TrackDto> getTracks() {
        log.info("вызван getTracks");

        return trackRepository.findAll().stream()
            .map(trackMapper::toDto)
            .toList();
    }

    @Override
    public TrackDto addTrack(TrackDto trackDto) {
        log.info("вызван addTrack");

        Track track = trackRepository.save(trackMapper.toModel(trackDto));

        return trackMapper.toDto(track);
    }

    @Override
    public TrackDto getTrackById(Long id) {
        log.info("вызван getTrackById");

        Optional<Track> track = trackRepository.findById(id);

        if (track.isEmpty()) {
            throw new CommonOnboardingApiException(ErrorType.NOT_FOUND, id);
        }

        return trackMapper.toDto(track.get());
    }
}

package suai.vladislav.onboardingapi.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import suai.vladislav.onboardingapi.dto.TrackDto;
import suai.vladislav.onboardingapi.models.Track;
import suai.vladislav.onboardingapi.repositories.TrackRepository;
import suai.vladislav.onboardingapi.services.interfaces.TrackService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrackServiceImpl implements TrackService {

    private final TrackRepository trackRepository;

    @Override
    public List<TrackDto> getTracks() {
        return trackRepository.findAll().stream()
            .map(track -> TrackDto.builder()
                .id(track.getId())
                .name(track.getName())
                .modulesCount(track.getModulesCount())
                .build()
            )
            .toList();
    }

    @Override
    public TrackDto addTrack(TrackDto trackDto) {
        Track track = trackRepository.save(Track.builder()
            .name(trackDto.name())
            .modulesCount(trackDto.modulesCount())
            .build()
        );

        return TrackDto.builder()
            .id(track.getId())
            .name(track.getName())
            .modulesCount(track.getModulesCount())
            .build();
    }
}

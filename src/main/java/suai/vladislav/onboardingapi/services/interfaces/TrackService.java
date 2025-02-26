package suai.vladislav.onboardingapi.services.interfaces;

import suai.vladislav.onboardingapi.dto.TrackDto;

import java.util.List;

public interface TrackService {
    List<TrackDto> getTracks();

    TrackDto addTrack(TrackDto trackDto);

    TrackDto getTrackById(Long id);
}

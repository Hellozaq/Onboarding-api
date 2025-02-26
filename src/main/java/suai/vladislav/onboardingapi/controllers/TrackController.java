package suai.vladislav.onboardingapi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import suai.vladislav.onboardingapi.dto.TrackDto;
import suai.vladislav.onboardingapi.services.interfaces.TrackService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tracks")
public class TrackController {

    private final TrackService trackService;

    @GetMapping()
    public List<TrackDto> getTracks() {
        return trackService.getTracks();
    }

    @GetMapping("/{trackId}")
    public TrackDto getTrack(@PathVariable("trackId") Long trackId) {
        return trackService.getTrackById(trackId);
    }

    @PostMapping()
    public TrackDto addTrack(@Validated @RequestBody TrackDto trackDto) {
        return trackService.addTrack(trackDto);
    }
}

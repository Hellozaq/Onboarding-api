package suai.vladislav.onboardingapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import suai.vladislav.onboardingapi.dto.TrackDto;
import suai.vladislav.onboardingapi.service.interfaces.TrackService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/track")
public class TrackController {

    private final TrackService trackService;

    @GetMapping
    public List<TrackDto> getTracks() {
        return trackService.getTracks();
    }

    @GetMapping("/{trackId}")
    public TrackDto getTrack(
        @PathVariable("trackId") Long trackId
    ) {
        return trackService.getTrackById(trackId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrackDto addTrack(
        @Validated
        @RequestBody TrackDto trackDto
    ) {
        return trackService.addTrack(trackDto);
    }

    @PutMapping
    public TrackDto updateTrack(
        @Validated
        @RequestBody TrackDto trackDto
    ) {
        return trackService.updateTrack(trackDto);
    }

    @DeleteMapping("/{trackId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrack(
        @Validated
        @PathVariable("trackId") Long trackId
    ) {
        trackService.deleteTrack(trackId);
    }
}

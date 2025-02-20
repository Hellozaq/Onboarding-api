package suai.vladislav.onboardingapi.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import suai.vladislav.onboardingapi.dto.TrackDto;
import suai.vladislav.onboardingapi.models.Track;

import java.util.List;

@Mapper(componentModel = "spring", uses = ModuleMapper.class)
public interface TrackMapper {
    TrackDto toDto(TrackDto trackDto);

    @Mapping(target = "modules", ignore = true)
    Track toModel(TrackDto trackDto);

    List<TrackDto> toTrackDtoList(List<Track> tracks);
}

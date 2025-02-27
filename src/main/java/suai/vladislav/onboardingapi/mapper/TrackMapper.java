package suai.vladislav.onboardingapi.mapper;

import org.mapstruct.Mapper;
import suai.vladislav.onboardingapi.config.MapperConfig;
import suai.vladislav.onboardingapi.dto.TrackDto;
import suai.vladislav.onboardingapi.model.Track;

@Mapper(config = MapperConfig.class, uses = ModuleMapper.class)
public interface TrackMapper {
    TrackDto toDto(Track track);

    Track toModel(TrackDto trackDto);
}
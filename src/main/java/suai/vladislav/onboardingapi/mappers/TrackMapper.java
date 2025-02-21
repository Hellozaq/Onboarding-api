package suai.vladislav.onboardingapi.mappers;

import org.mapstruct.Mapper;
import suai.vladislav.onboardingapi.configs.MapperConfig;
import suai.vladislav.onboardingapi.dto.TrackDto;
import suai.vladislav.onboardingapi.models.Track;

@Mapper(config = MapperConfig.class, uses = ModuleMapper.class)
public interface TrackMapper {
    TrackDto toDto(Track track);

    Track toModel(TrackDto trackDto);
}
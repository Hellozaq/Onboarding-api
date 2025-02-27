package suai.vladislav.onboardingapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import suai.vladislav.onboardingapi.config.MapperConfig;
import suai.vladislav.onboardingapi.dto.ScoreboardDto;
import suai.vladislav.onboardingapi.model.Scoreboard;

@Mapper(config = MapperConfig.class)
public interface ScoreboardMapper {
    @Mapping(target = "userId", source = "user.id")
    ScoreboardDto toDto(Scoreboard scoreboard);

    Scoreboard toModel(ScoreboardDto scoreboardDto);
}

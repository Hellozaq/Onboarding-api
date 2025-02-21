package suai.vladislav.onboardingapi.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import suai.vladislav.onboardingapi.configs.MapperConfig;
import suai.vladislav.onboardingapi.dto.ScoreboardDto;
import suai.vladislav.onboardingapi.models.Scoreboard;

@Mapper(config = MapperConfig.class)
public interface ScoreboardMapper {
    @Mapping(target = "userId", source = "user.id")
    ScoreboardDto toDto(Scoreboard scoreboard);

    Scoreboard toModel(ScoreboardDto scoreboardDto);
}

package suai.vladislav.onboardingapi.mapper;

import org.mapstruct.Mapper;
import suai.vladislav.onboardingapi.config.MapperConfig;
import suai.vladislav.onboardingapi.dto.SurveyDto;
import suai.vladislav.onboardingapi.model.Survey;

@Mapper(config = MapperConfig.class, uses = ModuleMapper.class)
public interface SurveyMapper {
    SurveyDto toDto(Survey survey);

    Survey toModel(SurveyDto surveyDto);
}

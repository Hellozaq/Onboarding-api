package suai.vladislav.onboardingapi.mapper;

import org.mapstruct.Mapper;
import suai.vladislav.onboardingapi.config.MapperConfig;
import suai.vladislav.onboardingapi.dto.KnowledgeBaseDto;
import suai.vladislav.onboardingapi.model.KnowledgeBase;

@Mapper(config = MapperConfig.class)
public interface KnowledgeBaseMapper {
    KnowledgeBaseDto toDto(KnowledgeBase knowledgeBase);

    KnowledgeBase toModel(KnowledgeBaseDto knowledgeBaseDto);
}

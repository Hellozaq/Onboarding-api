package suai.vladislav.onboardingapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import suai.vladislav.onboardingapi.config.MapperConfig;
import suai.vladislav.onboardingapi.dto.ModuleDto;
import suai.vladislav.onboardingapi.model.Module;

@Mapper(config = MapperConfig.class)
public interface ModuleMapper {

    @Mapping(target = "pagesCount", expression = "java(module.getPages() != null ? module.getPages().size() : 0)")
    @Mapping(target = "trackId", source = "track.id")
    ModuleDto toDto(Module module);

    Module toModel(ModuleDto moduleDto);
}

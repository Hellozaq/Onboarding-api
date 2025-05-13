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
import suai.vladislav.onboardingapi.dto.ModuleDto;
import suai.vladislav.onboardingapi.service.interfaces.ModuleService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/module")
public class ModuleController {

    private final ModuleService moduleService;

    @GetMapping
    public List<ModuleDto> getModules() {
        return moduleService.getModules();
    }

    @GetMapping("/{moduleId}")
    public ModuleDto getModule(
        @PathVariable("moduleId") Long moduleId
    ) {
        return moduleService.getModuleById(moduleId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ModuleDto addModule(
        @Validated
        @RequestBody ModuleDto moduleDto
    ) {
        return moduleService.addModule(moduleDto);
    }

    @PutMapping
    public ModuleDto updateModule(
        @Validated
        @RequestBody ModuleDto moduleDto
    ) {
        return moduleService.updateModule(moduleDto);
    }

    @DeleteMapping("/{moduleId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteModule(
        @PathVariable("moduleId") Long moduleId
    ) {
        moduleService.deleteModule(moduleId);
    }
}

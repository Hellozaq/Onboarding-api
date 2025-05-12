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
import suai.vladislav.onboardingapi.dto.KnowledgeBaseDto;
import suai.vladislav.onboardingapi.service.interfaces.KnowledgeBaseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/knowledgebase")
public class KnowledgeBaseController {

    private final KnowledgeBaseService knowledgeBaseService;

    @GetMapping
    public List<KnowledgeBaseDto> getKnowledgeBases() {
        return knowledgeBaseService.getKnowledgeBases();
    }

    @GetMapping("/{knowledgeBaseId}")
    public KnowledgeBaseDto getKnowledgeBase(
        @PathVariable("knowledgeBaseId") Long knowledgeBaseId
    ) {
        return knowledgeBaseService.getKnowledgeBaseById(knowledgeBaseId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public KnowledgeBaseDto addKnowledgeBase(
        @Validated
        @RequestBody KnowledgeBaseDto knowledgeBaseDto
    ) {
        return knowledgeBaseService.addKnowledgeBase(knowledgeBaseDto);
    }

    @PutMapping
    public KnowledgeBaseDto updateKnowledgeBase(
        @Validated
        @RequestBody KnowledgeBaseDto knowledgeBaseDto
    ) {
        return knowledgeBaseService.updateKnowledgeBase(knowledgeBaseDto);
    }

    @DeleteMapping("/{knowledgeBaseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteKnowledgeBase(
        @Validated
        @PathVariable("knowledgeBaseId") Long knowledgeBaseId
    ) {
        knowledgeBaseService.deleteKnowledgeBase(knowledgeBaseId);
    }
}

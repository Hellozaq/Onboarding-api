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
import suai.vladislav.onboardingapi.dto.PageDto;
import suai.vladislav.onboardingapi.service.interfaces.PageService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/pages")
public class PageController {

    private final PageService pageService;

    @GetMapping
    public List<PageDto> getPages() {
        return pageService.getPages();
    }

    @GetMapping("/{pageId}")
    public PageDto getPage(@PathVariable("pageId") Long pageId) {
        return pageService.getPageById(pageId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PageDto addPage(@Validated @RequestBody PageDto pageDto) {
        return pageService.addPage(pageDto);
    }

    @PutMapping
    public PageDto updatePage(@Validated @RequestBody PageDto pageDto) {
        return pageService.updatePage(pageDto);
    }

    @DeleteMapping("/{pageId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePage(@Validated @PathVariable("pageId") Long pageId) {
        pageService.deletePage(pageId);
    }
}
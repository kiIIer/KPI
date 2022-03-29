package io.promova.newsservice.endpoints.titles;

import io.promova.newsservice.config.EnvConfig;
import io.promova.newsservice.endpoints.titles.entities.PagedTitlesResponse;
import io.promova.newsservice.endpoints.titles.exceptions.TitleEntityNotFoundException;
import io.promova.newsservice.endpoints.titles.tools.IAcceptHeaderProcessor;
import io.promova.newsservice.endpoints.titles.tools.PagedTitlesModelAssembler;
import io.promova.newsservice.endpoints.titles.tools.TitleModelAssembler;
import io.promova.newsservice.reps.ITitleRepository;
import io.promova.newsservice.reps.TitleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TitlesController
{
    private final EnvConfig config;
    private final IAcceptHeaderProcessor headerProcessor;
    private final ITitleRepository repository;
    private final TitleModelAssembler modelAssembler;
    private final PagedTitlesModelAssembler pagedModelAssembler;

    public TitlesController(
            EnvConfig config,
            IAcceptHeaderProcessor headerProcessor,
            ITitleRepository repository,
            TitleModelAssembler modelAssembler, PagedTitlesModelAssembler pagedModelAssembler)
    {
        this.config = config;
        this.headerProcessor = headerProcessor;
        this.repository = repository;
        this.modelAssembler = modelAssembler;
        this.pagedModelAssembler = pagedModelAssembler;
    }

    @GetMapping("/titles")
    public ResponseEntity<EntityModel<PagedTitlesResponse>> all(
            @RequestParam(defaultValue = "0") int page,
            @RequestHeader("Accept") String acceptHeader
    )
    {
        Page<TitleEntity> currentPage = repository.findAll(
                PageRequest.of(
                        page,
                        config.getPages(),
                        Sort.by("dateCreated").descending()
                )
        );

        List<TitleEntity> titleEntities = currentPage.getContent();

        Integer nextPage = currentPage.hasNext() ? page + 1 : null;

        return new ResponseEntity<>(
                pagedModelAssembler.toModel(titleEntities, headerProcessor.areLinksEnables(acceptHeader), nextPage),
                HttpStatus.OK
        );

    }

    @GetMapping("/titles/{id}")
    public ResponseEntity<EntityModel<TitleEntity>> one(
            @PathVariable String id,
            @RequestHeader("Accept") String acceptHeader
    )
    {
        TitleEntity titleEntity = repository.findById(id).orElseThrow(() -> new TitleEntityNotFoundException(id));

        return new ResponseEntity<>(
                modelAssembler.toModel(titleEntity, headerProcessor.areLinksEnables(acceptHeader)),
                HttpStatus.OK
        );

    }
}

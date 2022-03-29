package io.promova.newsservice.endpoints.titles;

import io.promova.newsservice.config.EnvConfig;
import io.promova.newsservice.endpoints.titles.entities.PagedTitlesResponse;
import io.promova.newsservice.endpoints.titles.exceptions.InvalidRequestException;
import io.promova.newsservice.endpoints.titles.exceptions.TitleEntityNotFoundException;
import io.promova.newsservice.endpoints.titles.tools.IAcceptHeaderProcessor;
import io.promova.newsservice.endpoints.titles.tools.IPagedTitlesModelAssembler;
import io.promova.newsservice.endpoints.titles.tools.ITitleModelAssembler;
import io.promova.newsservice.endpoints.titles.tools.util.TitlesAllGetRequest;
import io.promova.newsservice.endpoints.titles.validators.IIdValidator;
import io.promova.newsservice.endpoints.titles.validators.IValidator;
import io.promova.newsservice.endpoints.util.APISubError;
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
    private final ITitleModelAssembler modelAssembler;
    private final IPagedTitlesModelAssembler pagedModelAssembler;
    private final IValidator<TitlesAllGetRequest> getAllValidator;
    private final IIdValidator idValidator;

    public TitlesController(
            EnvConfig config,
            IAcceptHeaderProcessor headerProcessor,
            ITitleRepository repository,
            ITitleModelAssembler modelAssembler,
            IPagedTitlesModelAssembler pagedModelAssembler,
            IValidator<TitlesAllGetRequest> getAllValidator,
            IIdValidator idValidator
    )
    {
        this.config = config;
        this.headerProcessor = headerProcessor;
        this.repository = repository;
        this.modelAssembler = modelAssembler;
        this.pagedModelAssembler = pagedModelAssembler;
        this.getAllValidator = getAllValidator;
        this.idValidator = idValidator;
    }

    @GetMapping("/titles")
    public ResponseEntity<EntityModel<PagedTitlesResponse>> all(
            @RequestParam(required = false) String page,
            @RequestParam(required = false) String pageSize,
            @RequestHeader("Accept") String acceptHeader
    )
    {
        page = page == null ? "0" : page;
        pageSize = pageSize == null ? String.valueOf(config.getMaxPageSize()) : pageSize;

        TitlesAllGetRequest request = new TitlesAllGetRequest(page, pageSize, acceptHeader);

        List<APISubError> errors = getAllValidator.validate(request);
        if (errors.size() != 0)
        {
            throw new InvalidRequestException("Request you sent has invalid parameters", errors);
        }
        int pageNumber = Integer.parseInt(page);
        int pageSizeNumber = Integer.parseInt(pageSize);

        Page<TitleEntity> currentPage = repository.findAll(
                PageRequest.of(
                        pageNumber,
                        pageSizeNumber,
                        Sort.by("dateCreated").descending()
                )
        );

        List<TitleEntity> titleEntities = currentPage.getContent();

        Integer nextPage = currentPage.hasNext() ? pageNumber + 1 : null;

        return new ResponseEntity<>(
                pagedModelAssembler.toModel(
                        titleEntities,
                        headerProcessor.areLinksEnables(request.getAcceptHeader()),
                        nextPage,
                        pageSizeNumber
                ),
                HttpStatus.OK
        );

    }

    @GetMapping("/titles/{id}")
    public ResponseEntity<EntityModel<TitleEntity>> one(
            @PathVariable String id,
            @RequestHeader("Accept") String acceptHeader
    )
    {
        List<APISubError> errors = idValidator.validate(id);
        if (errors.size() != 0)
        {
            throw new TitleEntityNotFoundException("This title does not exist");
        }

        TitleEntity titleEntity = repository.findById(id).orElseThrow(() -> new TitleEntityNotFoundException(id));

        return new ResponseEntity<>(
                modelAssembler.toModel(titleEntity, headerProcessor.areLinksEnables(acceptHeader)),
                HttpStatus.OK
        );

    }
}

package io.promova.newsservice.endpoints.titles;

import io.promova.newsservice.config.EnviromentalConfig;
import io.promova.newsservice.endpoints.titles.entities.PagedTitlesResponse;
import io.promova.newsservice.endpoints.titles.entities.PostOneTitleRequest;
import io.promova.newsservice.endpoints.util.exceptions.InvalidRequestException;
import io.promova.newsservice.endpoints.util.exceptions.EntityNotFoundException;
import io.promova.newsservice.endpoints.util.tools.IAcceptHeaderProcessor;
import io.promova.newsservice.endpoints.titles.tools.IPagedTitlesModelAssembler;
import io.promova.newsservice.endpoints.titles.tools.ITitleEntityCreator;
import io.promova.newsservice.endpoints.titles.tools.ITitleModelAssembler;
import io.promova.newsservice.endpoints.titles.tools.util.TitlesAllGetRequest;
import io.promova.newsservice.endpoints.util.validators.IIdValidator;
import io.promova.newsservice.endpoints.titles.validators.IOneTitleRequestValidator;
import io.promova.newsservice.endpoints.util.validators.IValidator;
import io.promova.newsservice.endpoints.util.APISubError;
import io.promova.newsservice.reps.ITitleRepository;
import io.promova.newsservice.reps.TitleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TitlesController
{
    private final EnviromentalConfig config;
    private final IAcceptHeaderProcessor headerProcessor;
    private final ITitleRepository repository;
    private final ITitleModelAssembler modelAssembler;
    private final IPagedTitlesModelAssembler pagedModelAssembler;
    private final IValidator<TitlesAllGetRequest> getAllValidator;
    private final IIdValidator idValidator;
    private final ITitleEntityCreator titleEntityCreator;
    private final IOneTitleRequestValidator oneTitleRequestValidator;

    public TitlesController(
            EnviromentalConfig config,
            IAcceptHeaderProcessor headerProcessor,
            ITitleRepository repository,
            ITitleModelAssembler modelAssembler,
            IPagedTitlesModelAssembler pagedModelAssembler,
            IValidator<TitlesAllGetRequest> getAllValidator,
            IIdValidator idValidator,
            ITitleEntityCreator titleEntityCreator, IOneTitleRequestValidator oneTitleRequestValidator)
    {
        this.config = config;
        this.headerProcessor = headerProcessor;
        this.repository = repository;
        this.modelAssembler = modelAssembler;
        this.pagedModelAssembler = pagedModelAssembler;
        this.getAllValidator = getAllValidator;
        this.idValidator = idValidator;
        this.titleEntityCreator = titleEntityCreator;
        this.oneTitleRequestValidator = oneTitleRequestValidator;
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

    @PostMapping(value = "/titles", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EntityModel<TitleEntity>> postOne(
            @RequestHeader("Accept") String acceptHeader,
            @RequestBody PostOneTitleRequest requestBody
    )
    {
        List<APISubError> errors = oneTitleRequestValidator.validate(requestBody);
        if (errors.size() != 0)
        {
            throw new InvalidRequestException("Body is invalid", errors);
        }
        TitleEntity titleEntity = titleEntityCreator.create(requestBody.getTitle());
        TitleEntity save = repository.save(titleEntity);

        return new ResponseEntity<>(
                modelAssembler.toModel(save, headerProcessor.areLinksEnables(acceptHeader), config.getMaxPageSize()),
                HttpStatus.CREATED
        );
    }

    @PatchMapping(value = "/titles/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EntityModel<TitleEntity>> patchOne(
            @PathVariable String id,
            @RequestHeader("Accept") String acceptHeader,
            @RequestBody PostOneTitleRequest requestBody
    )
    {
        List<APISubError> errors = idValidator.validate(id);
        if (errors.size() != 0)
        {
            throw new EntityNotFoundException(id, errors);
        }

        errors = oneTitleRequestValidator.validate(requestBody);
        if (errors.size() != 0)
        {
            throw new InvalidRequestException("Body is invalid", errors);
        }
        TitleEntity titleEntity = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id, List.of(new APISubError("Not found in database"))
                ));
        titleEntity.setTitle(requestBody.getTitle());
        TitleEntity save = repository.save(titleEntity);

        return new ResponseEntity<>(
                modelAssembler.toModel(save, headerProcessor.areLinksEnables(acceptHeader), config.getMaxPageSize()),
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
            throw new EntityNotFoundException(id, errors);
        }

        TitleEntity titleEntity = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id, List.of(new APISubError("Not found in database"))
                ));

        return new ResponseEntity<>(
                modelAssembler.toModel(titleEntity, headerProcessor.areLinksEnables(acceptHeader), config.getMaxPageSize()),
                HttpStatus.OK
        );

    }

    @DeleteMapping("/titles/{id}")
    public ResponseEntity<Object> one(
            @PathVariable String id
    )
    {
        repository.deleteById(id);

        return new ResponseEntity<>(
                HttpStatus.NO_CONTENT
        );
    }
}

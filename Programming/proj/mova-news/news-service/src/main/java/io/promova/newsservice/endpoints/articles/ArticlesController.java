package io.promova.newsservice.endpoints.articles;

import io.promova.newsservice.endpoints.articles.entities.OneArticleRequest;
import io.promova.newsservice.endpoints.articles.tools.IArticleEntityCreator;
import io.promova.newsservice.endpoints.articles.tools.IArticleModelAssembler;
import io.promova.newsservice.endpoints.articles.validators.IPostOneArticleRequestValidator;
import io.promova.newsservice.endpoints.util.APISubError;
import io.promova.newsservice.endpoints.util.exceptions.EntityNotFoundException;
import io.promova.newsservice.endpoints.util.exceptions.InvalidRequestException;
import io.promova.newsservice.endpoints.util.tools.IAcceptHeaderProcessor;
import io.promova.newsservice.endpoints.util.validators.IIdValidator;
import io.promova.newsservice.reps.ArticleEntity;
import io.promova.newsservice.reps.IArticleRepository;
import io.promova.newsservice.reps.TitleEntity;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticlesController
{
    private final IArticleRepository repository;
    private final IArticleModelAssembler modelAssembler;
    private final IAcceptHeaderProcessor headerProcessor;
    private final IIdValidator idValidator;
    private final IPostOneArticleRequestValidator oneArticleRequestValidator;
    private final IArticleEntityCreator articleEntityCreator;

    public ArticlesController(IArticleRepository repository,
                              IArticleModelAssembler modelAssembler,
                              IAcceptHeaderProcessor headerProcessor,
                              IIdValidator idValidator, IPostOneArticleRequestValidator oneArticleRequestValidator, IArticleEntityCreator articleEntityCreator)
    {
        this.repository = repository;
        this.modelAssembler = modelAssembler;
        this.headerProcessor = headerProcessor;
        this.idValidator = idValidator;
        this.oneArticleRequestValidator = oneArticleRequestValidator;
        this.articleEntityCreator = articleEntityCreator;
    }

    @GetMapping("/titles/{id}/article")
    public ResponseEntity<EntityModel<ArticleEntity>> one(
            @PathVariable String id,
            @RequestHeader("Accept") String acceptHeader
    )
    {
        List<APISubError> errors = idValidator.validate(id);
        if (errors.size() != 0)
        {
            throw new EntityNotFoundException(id, errors);
        }

        ArticleEntity articleEntity = repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(id, List.of(new APISubError("Not found in database")))
        );

        return new ResponseEntity<>(
                modelAssembler.toModel(articleEntity, headerProcessor.areLinksEnables(acceptHeader)),
                HttpStatus.OK
        );
    }

    @PostMapping(value = "/titles/{id}/article", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EntityModel<ArticleEntity>> postOne(
            @PathVariable String id,
            @RequestHeader("Accept") String acceptHeader,
            @RequestBody OneArticleRequest requestBody
    )
    {
        List<APISubError> errors = idValidator.validate(id);
        if (errors.size() != 0)
        {
            throw new EntityNotFoundException(id, errors);
        }

        errors = oneArticleRequestValidator.validate(requestBody);
        if (errors.size() != 0)
        {
            throw new InvalidRequestException("Body is invalid", errors);
        }

        ArticleEntity articleEntity = articleEntityCreator.create(id, requestBody.getArticle());
        ArticleEntity save = repository.save(articleEntity);

        return new ResponseEntity<>(
                modelAssembler.toModel(save, headerProcessor.areLinksEnables(acceptHeader)),
                HttpStatus.CREATED
        );
    }

    @PatchMapping(value = "/titles/{id}/article", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EntityModel<ArticleEntity>> patchOne(
            @PathVariable String id,
            @RequestHeader("Accept") String acceptHeader,
            @RequestBody OneArticleRequest requestBody
    )
    {
        List<APISubError> errors = idValidator.validate(id);
        if (errors.size() != 0)
        {
            throw new EntityNotFoundException(id, errors);
        }

        errors = oneArticleRequestValidator.validate(requestBody);
        if (errors.size() != 0)
        {
            throw new InvalidRequestException("Body is invalid", errors);
        }

        ArticleEntity articleEntity = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id, List.of(new APISubError("Not found in database"))
                ));
        articleEntity.setArticle(requestBody.getArticle());
        ArticleEntity save = repository.save(articleEntity);

        return new ResponseEntity<>(
                modelAssembler.toModel(save, headerProcessor.areLinksEnables(acceptHeader)),
                HttpStatus.CREATED
        );
    }
}

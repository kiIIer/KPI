package io.promova.newsservice.endpoints;

import io.promova.newsservice.endpoints.entities.*;
import io.promova.newsservice.endpoints.error.exceptions.NewsNotFoundException;
import io.promova.newsservice.endpoints.tools.IAcceptHeaderParser;
import io.promova.newsservice.endpoints.tools.IResponseAllTitlesEntityModelAssembler;
import io.promova.newsservice.endpoints.tools.ISingleTitleEntityModelAssembler;
import io.promova.newsservice.rep.INewsRepository;
import io.promova.newsservice.rep.NewsEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class TitleController
{
    private final INewsRepository newsRepository;
    private final ISingleTitleEntityModelAssembler modelAssembler;
    private final IResponseAllTitlesEntityModelAssembler allModelAssembler;
    private final IAcceptHeaderParser acceptHeaderParser;

    public TitleController(
            INewsRepository newsRepository,
            ISingleTitleEntityModelAssembler modelAssembler,
            IResponseAllTitlesEntityModelAssembler allModelAssembler,
            IAcceptHeaderParser acceptHeaderParser)
    {
        this.newsRepository = newsRepository;
        this.modelAssembler = modelAssembler;
        this.allModelAssembler = allModelAssembler;
        this.acceptHeaderParser = acceptHeaderParser;
    }

    @GetMapping(value = "/titles/{id}")
    public ResponseEntity<EntityModel<TitleEntity>> getOne(
            @PathVariable String id,
            @RequestHeader("Accept") String acceptHeader
    )
    {
        NewsEntity news = newsRepository.findById(id)
                .orElseThrow(
                        () -> new NewsNotFoundException(id)
                );


        return
                new ResponseEntity<>(
                        modelAssembler.toModel(new TitleEntity(news), acceptHeaderParser.addLinks(acceptHeader)),
                        HttpStatus.OK
                );
    }

//    @GetMapping(value = "/titles/all")
//    public ResponseEntity<EntityModel<ResponseAllTitlesEntity>> getAll()
//    {
//        List<NewsEntity> all = newsRepository.findAll();
//        return getEntityModelResponseEntity(all);
//    }

    @GetMapping(value = "/titles")
    public ResponseEntity<EntityModel<ResponseAllTitlesEntity>> getPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestHeader("Accept") String acceptHeader
    )
    {
        List<NewsEntity> all = newsRepository.findAll(PageRequest.of(page, 10, Sort.by("datecreated").descending())).getContent();
        return getEntityModelResponseEntity(all, page, acceptHeaderParser.addLinks(acceptHeader));
    }

    @NotNull
    private ResponseEntity<EntityModel<ResponseAllTitlesEntity>> getEntityModelResponseEntity(
            List<NewsEntity> all,
            int page,
            boolean addLinks
    )
    {
        List<TitleEntity> allTitles = all.stream().map(TitleEntity::new).toList();
        AllTitlesEntity allTitlesEntity = new AllTitlesEntity(allTitles.toArray(new TitleEntity[0]));
        EntityModel<ResponseAllTitlesEntity> responseAllNewsEntityEntityModel = allModelAssembler.toModel(allTitlesEntity, addLinks);
        if (addLinks && allTitles.size() == 10)
        {
            responseAllNewsEntityEntityModel.add(linkTo(methodOn(TitleController.class).getPaged(page + 1, "*/*")).withRel("nextPage"));
        }
        return new ResponseEntity<>(responseAllNewsEntityEntityModel, HttpStatus.OK);
    }

}

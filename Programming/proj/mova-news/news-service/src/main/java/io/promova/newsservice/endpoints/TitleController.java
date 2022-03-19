package io.promova.newsservice.endpoints;

import io.promova.newsservice.endpoints.entities.*;
import io.promova.newsservice.endpoints.error.exceptions.NewsNotFoundException;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class TitleController
{
    private final INewsRepository newsRepository;
    private final ISingleTitleEntityModelAssembler modelAssembler;
    private final IResponseAllTitlesEntityModelAssembler allModelAssembler;

    public TitleController(
            INewsRepository newsRepository,
            ISingleTitleEntityModelAssembler modelAssembler,
            IResponseAllTitlesEntityModelAssembler allModelAssembler
    )
    {
        this.newsRepository = newsRepository;
        this.modelAssembler = modelAssembler;
        this.allModelAssembler = allModelAssembler;
    }

    @GetMapping(value = "/titles/{id}")
    public ResponseEntity<EntityModel<TitleEntity>> getOne(@PathVariable String id)
    {
        NewsEntity news = newsRepository.findById(id)
                .orElseThrow(
                        () -> new NewsNotFoundException(id)
                );


        return
                new ResponseEntity<>(
                        modelAssembler.toModel(new TitleEntity(news)),
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
    public ResponseEntity<EntityModel<ResponseAllTitlesEntity>> getPaged(@RequestParam(defaultValue = "0") int page)
    {
        List<NewsEntity> all = newsRepository.findAll(PageRequest.of(page, 10, Sort.by("datecreated").descending())).getContent();
        return getEntityModelResponseEntity(all, page);
    }

    @NotNull
    private ResponseEntity<EntityModel<ResponseAllTitlesEntity>> getEntityModelResponseEntity(List<NewsEntity> all, int page)
    {
        List<TitleEntity> allTitles = all.stream().map(TitleEntity::new).toList();
        AllTitlesEntity allTitlesEntity = new AllTitlesEntity(allTitles.toArray(new TitleEntity[0]));
        EntityModel<ResponseAllTitlesEntity> responseAllNewsEntityEntityModel = allModelAssembler.toModel(allTitlesEntity);
        if (allTitles.size() == 10)
        {
            responseAllNewsEntityEntityModel.add(linkTo(methodOn(TitleController.class).getPaged(page + 1)).withSelfRel());
        }
        return new ResponseEntity<>(responseAllNewsEntityEntityModel, HttpStatus.OK);
    }

}

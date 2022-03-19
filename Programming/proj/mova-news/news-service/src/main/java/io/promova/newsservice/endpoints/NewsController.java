package io.promova.newsservice.endpoints;

import io.promova.newsservice.endpoints.entities.AllNewsEntity;
import io.promova.newsservice.endpoints.entities.ResponseAllNewsEntity;
import io.promova.newsservice.endpoints.tools.IResponseAllNewsEntityModelAssembler;
import io.promova.newsservice.endpoints.tools.ISingleNewsModelAssembler;
import io.promova.newsservice.rep.INewsRepository;
import io.promova.newsservice.rep.NewsEntity;
import io.promova.newsservice.endpoints.entities.RequestNewsEntity;
import io.promova.newsservice.endpoints.error.exceptions.NewsNotFoundException;
import jakarta.validation.Valid;
import org.jetbrains.annotations.NotNull;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class NewsController
{
    private final INewsRepository newsRepository;
    private final ISingleNewsModelAssembler modelAssembler;
    private final IResponseAllNewsEntityModelAssembler allModelAssembler;

    public NewsController(
            INewsRepository newsRepository,
            ISingleNewsModelAssembler modelAssembler,
            IResponseAllNewsEntityModelAssembler allModelAssembler
    )
    {
        this.newsRepository = newsRepository;
        this.modelAssembler = modelAssembler;
        this.allModelAssembler = allModelAssembler;
    }

//    @GetMapping(value = "/news/")
//    public ResponseEntity<EntityModel<ResponseAllNewsEntity>> getAll()
//    {
//        List<NewsEntity> all = newsRepository.findAll();
//        AllNewsEntity allNewsEntity = new AllNewsEntity(all.toArray(new NewsEntity[0]));
//        EntityModel<ResponseAllNewsEntity> responseAllNewsEntityEntityModel = allModelAssembler.toModel(allNewsEntity);
//        return new ResponseEntity<>(responseAllNewsEntityEntityModel, HttpStatus.OK);
//    }

    @GetMapping(value = "/titles/{id}/article")
    public ResponseEntity<EntityModel<NewsEntity>> getOne(@PathVariable String id)
    {
        NewsEntity news = newsRepository.findById(id)
                .orElseThrow(
                        () -> new NewsNotFoundException(id)
                );


        return
                new ResponseEntity<>(
                        modelAssembler.toModel(news),
                        HttpStatus.OK
                );
    }

    @PostMapping(value = "/titles/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EntityModel<NewsEntity>> postOne(@RequestBody @Valid @NotNull RequestNewsEntity newNews)
    {
        NewsEntity properNews = new NewsEntity(UUID.randomUUID().toString(), newNews.getTitle(), newNews.getArticle(), System.nanoTime());

        NewsEntity result = newsRepository.save(properNews);

        return new ResponseEntity<>(
                modelAssembler.toModel(result),
                HttpStatus.OK
        );
    }

    @PatchMapping(value = "/titles/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EntityModel<NewsEntity>> patchOne(@RequestBody @Valid @NotNull RequestNewsEntity newNews, @PathVariable String id)
    {
        newsRepository.findById(id).orElseThrow(() -> new NewsNotFoundException(id));

        NewsEntity properNews = new NewsEntity(id, newNews.getTitle(), newNews.getArticle(), System.nanoTime());

        NewsEntity result = newsRepository.save(properNews);

        return new ResponseEntity<>(
                modelAssembler.toModel(result),
                HttpStatus.OK
        );
    }

}

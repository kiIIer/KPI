package io.promova.newsservice.endpoints;

import io.promova.newsservice.endpoints.tools.IAcceptHeaderParser;
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

import java.util.UUID;

@RestController
public class NewsController
{
    private final INewsRepository newsRepository;
    private final ISingleNewsModelAssembler modelAssembler;
    private final IAcceptHeaderParser acceptHeaderParser;

    public NewsController(
            INewsRepository newsRepository,
            ISingleNewsModelAssembler modelAssembler,
            IAcceptHeaderParser acceptHeaderParser)
    {
        this.newsRepository = newsRepository;
        this.modelAssembler = modelAssembler;
        this.acceptHeaderParser = acceptHeaderParser;
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
    public ResponseEntity<EntityModel<NewsEntity>> getOne(
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
                        modelAssembler.toModel(news, acceptHeaderParser.addLinks(acceptHeader)),
                        HttpStatus.OK
                );
    }

    @PostMapping(value = "/titles/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EntityModel<NewsEntity>> postOne(
            @RequestBody @Valid @NotNull RequestNewsEntity newNews,
            @RequestHeader("Accept") String acceptHeader
    )
    {
        NewsEntity properNews = new NewsEntity(UUID.randomUUID().toString(), newNews.getTitle(), newNews.getArticle(), System.nanoTime());

        NewsEntity result = newsRepository.save(properNews);

        return new ResponseEntity<>(
                modelAssembler.toModel(result, acceptHeaderParser.addLinks(acceptHeader)),
                HttpStatus.CREATED
        );
    }

    @PatchMapping(value = "/titles/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EntityModel<NewsEntity>> patchOne(
            @RequestBody @Valid @NotNull RequestNewsEntity newNews,
            @PathVariable String id,
            @RequestHeader("Accept") String acceptHeader
    )
    {
        newsRepository.findById(id).orElseThrow(() -> new NewsNotFoundException(id));

        NewsEntity properNews = new NewsEntity(id, newNews.getTitle(), newNews.getArticle(), System.nanoTime());

        NewsEntity result = newsRepository.save(properNews);

        return new ResponseEntity<>(
                modelAssembler.toModel(result, acceptHeaderParser.addLinks(acceptHeader)),
                HttpStatus.OK
        );
    }

    @DeleteMapping(value = "/titles/{id}")
    public ResponseEntity<EntityModel<String>> deleteOne(
            @PathVariable String id
    )
    {
        newsRepository.deleteById(id);

        return new ResponseEntity<>(
                EntityModel.of("News with id " + id + " was deleted"),
                HttpStatus.OK
        );
    }

}

package io.promova.newsservice.endpoints;

import io.promova.newsservice.endpoints.entities.*;
import io.promova.newsservice.endpoints.error.exceptions.NewsNotFoundException;
import io.promova.newsservice.endpoints.tools.IResponseAllHeadersEntityModelAssembler;
import io.promova.newsservice.endpoints.tools.ISingleHeaderEntityModelAssembler;
import io.promova.newsservice.rep.INewsRepository;
import io.promova.newsservice.rep.NewsEntity;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HeaderController
{
    private final INewsRepository newsRepository;
    private final ISingleHeaderEntityModelAssembler modelAssembler;
    private final IResponseAllHeadersEntityModelAssembler allModelAssembler;

    public HeaderController(
            INewsRepository newsRepository,
            ISingleHeaderEntityModelAssembler modelAssembler,
            IResponseAllHeadersEntityModelAssembler allModelAssembler
    )
    {
        this.newsRepository = newsRepository;
        this.modelAssembler = modelAssembler;
        this.allModelAssembler = allModelAssembler;
    }

    @GetMapping(value = "/news/headers/{id}")
    public ResponseEntity<EntityModel<HeaderEntity>> getOne(@PathVariable String id)
    {
        NewsEntity news = newsRepository.findById(id)
                .orElseThrow(
                        () -> new NewsNotFoundException(id)
                );


        return
                new ResponseEntity<>(
                        modelAssembler.toModel(new HeaderEntity(news)),
                        HttpStatus.OK
                );
    }

    @GetMapping(value = "/news/headers")
    public ResponseEntity<EntityModel<ResponseAllHeadersEntity>> getAll()
    {
        List<NewsEntity> all = newsRepository.findAll();
        List<HeaderEntity> allHeaders = all.stream().map(HeaderEntity::new).toList();
        AllHeadersEntity allHeadersEntity = new AllHeadersEntity(allHeaders.toArray(new HeaderEntity[0]));
        EntityModel<ResponseAllHeadersEntity> responseAllNewsEntityEntityModel = allModelAssembler.toModel(allHeadersEntity);
        return new ResponseEntity<>(responseAllNewsEntityEntityModel, HttpStatus.OK);
    }

}

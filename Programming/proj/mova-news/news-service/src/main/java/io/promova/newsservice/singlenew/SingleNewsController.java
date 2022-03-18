package io.promova.newsservice.singlenew;

import io.promova.newsservice.rep.INewsRepository;
import io.promova.newsservice.rep.NewsEntity;
import io.promova.newsservice.singlenew.entities.RequestNewsEntity;
import io.promova.newsservice.singlenew.exceptions.SingleNewsNotFoundException;
import io.promova.newsservice.singlenew.tools.SingleNewsModelAssembler;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class SingleNewsController
{
    private final INewsRepository newsRepository;
    private final SingleNewsModelAssembler modelAssembler;

    public SingleNewsController(
            INewsRepository newsRepository,
            SingleNewsModelAssembler modelAssembler)
    {
        this.newsRepository = newsRepository;
        this.modelAssembler = modelAssembler;
    }

    @GetMapping(value = "/news/{id}")
    public ResponseEntity<EntityModel<NewsEntity>> getOne(@PathVariable String id)
    {
        NewsEntity news = newsRepository.findById(id)
                .orElseThrow(
                        () -> new SingleNewsNotFoundException(id)
                );


        return
                new ResponseEntity<>(
                        modelAssembler.toModel(news),
                        HttpStatus.OK
                );
    }

    @PostMapping(value = "/news/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EntityModel<NewsEntity>> putOne(@RequestBody @Valid RequestNewsEntity newNews)
    {
        NewsEntity properNews = new NewsEntity("a", newNews.getHeader(), newNews.getBody());

        newsRepository.save(properNews);

        return new ResponseEntity<>(
                modelAssembler.toModel(properNews),
                HttpStatus.OK
        );
    }

}

package io.promova.newsservice.singlenew;

import io.promova.newsservice.rep.INewsRepository;
import io.promova.newsservice.rep.NewsEntity;
import io.promova.newsservice.singlenew.exceptions.SingleNewsNotFoundException;
import jakarta.validation.Valid;
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

    public SingleNewsController(
            INewsRepository newsRepository
    )
    {
        this.newsRepository = newsRepository;
    }

    @GetMapping(value = "/news/{id}")
    public EntityModel<NewsEntity> getOne(@PathVariable long id)
    {
        NewsEntity news = newsRepository.findById(id)
                .orElseThrow(
                        () -> new SingleNewsNotFoundException(id)
                );


        return EntityModel.of(news,
                linkTo(methodOn(SingleNewsController.class).getOne(id)).withSelfRel());

        // TODO: make link to all
    }

    @PutMapping(value = "/news/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> putOne(@RequestBody @Valid NewsEntity newNews, @PathVariable long id)
    {
        newsRepository.save(newNews);

        return new ResponseEntity<>("News added successfully", HttpStatus.OK);
    }

}

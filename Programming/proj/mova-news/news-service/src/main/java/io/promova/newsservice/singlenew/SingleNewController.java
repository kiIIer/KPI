package io.promova.newsservice.singlenew;

import io.promova.newsservice.rep.INewsRepository;
import io.promova.newsservice.rep.NewsEntity;
import io.promova.newsservice.singlenew.exceptions.SingleNewsNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SingleNewController
{
    private final INewsRepository newsRepository;

    public SingleNewController(
            INewsRepository newsRepository
    )
    {
        this.newsRepository = newsRepository;
    }

    @GetMapping(value = "/news/{id}")
    public NewsEntity one(@PathVariable long id)
    {
        NewsEntity news = newsRepository.findById(id)
                .orElseThrow(
                        () -> new SingleNewsNotFoundException(id)
                );


        return news;
    }

}

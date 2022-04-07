package io.promova.newsservice.endpoints.search;

import io.promova.newsservice.reps.ITitleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController
{
    private final ITitleRepository titleRepository;

    public SearchController(ITitleRepository titleRepository)
    {
        this.titleRepository = titleRepository;
    }

    @GetMapping("/titles/search")
    public void basic()
    {
//        this.titleRepository.
    }
}

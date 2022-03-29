package io.promova.newsservice.endpoints.titles.tools;

import io.promova.newsservice.endpoints.titles.TitlesController;
import io.promova.newsservice.endpoints.titles.entities.PagedTitlesResponse;
import io.promova.newsservice.reps.TitleEntity;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

public class PagedTitlesModelAssembler
{
    private final TitleModelAssembler modelAssembler;

    public PagedTitlesModelAssembler(TitleModelAssembler modelAssembler)
    {
        this.modelAssembler = modelAssembler;
    }

    public EntityModel<PagedTitlesResponse> toModel(List<TitleEntity> titles, boolean areLinksEnabled, Integer nextPage)
    {
        PagedTitlesResponse pagedTitlesResponse = make(titles, areLinksEnabled);
        EntityModel<PagedTitlesResponse> entityModel = EntityModel.of(pagedTitlesResponse);
        if (areLinksEnabled)
        {
            entityModel.add(
                    linkTo(methodOn(TitlesController.class).all(0, "*/*")).withSelfRel()
            );
            if (nextPage != null)
            {
                entityModel.add(
                        linkTo(methodOn(TitlesController.class).all(nextPage, "*/*")).withRel("nextPage")
                );
            }
        }
        return entityModel;
    }

    private PagedTitlesResponse make(List<TitleEntity> titles, boolean areLinksEnabled)
    {
        return new PagedTitlesResponse(titles.stream().map(title -> modelAssembler.toModel(title, areLinksEnabled)).toList());

    }
}

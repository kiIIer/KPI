package io.promova.newsservice.endpoints.titles.tools;

import io.promova.newsservice.endpoints.titles.TitlesController;
import io.promova.newsservice.endpoints.titles.entities.PagedTitlesResponse;
import io.promova.newsservice.reps.TitleEntity;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

public class PagedTitlesModelAssembler implements IPagedTitlesModelAssembler
{
    private final ITitleModelAssembler modelAssembler;

    public PagedTitlesModelAssembler(ITitleModelAssembler modelAssembler)
    {
        this.modelAssembler = modelAssembler;
    }

    @Override
    public EntityModel<PagedTitlesResponse> toModel(List<TitleEntity> titles, boolean areLinksEnabled, Integer nextPage, Integer pageSize, String acceptHeader)
    {
        PagedTitlesResponse pagedTitlesResponse = make(titles, areLinksEnabled, pageSize);
        EntityModel<PagedTitlesResponse> entityModel = EntityModel.of(pagedTitlesResponse);

        if (nextPage != null)
        {
            entityModel.add(
                    linkTo(methodOn(TitlesController.class).all(String.valueOf(nextPage), String.valueOf(pageSize), "", acceptHeader)).withRel("nextPage")
            );
        }
        return entityModel;
    }

    private PagedTitlesResponse make(List<TitleEntity> titles, boolean areLinksEnabled, Integer pageSize)
    {
        return new PagedTitlesResponse(titles.stream().map(title -> modelAssembler.toModel(title, areLinksEnabled, pageSize)).toList());

    }
}

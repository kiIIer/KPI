package io.promova.newsservice.endpoints.titles.tools;

import io.promova.newsservice.endpoints.titles.entities.PagedTitlesResponse;
import io.promova.newsservice.reps.TitleEntity;
import org.springframework.hateoas.EntityModel;

import java.util.List;

public interface IPagedTitlesModelAssembler
{
    EntityModel<PagedTitlesResponse> toModel(List<TitleEntity> titles, boolean areLinksEnabled, Integer nextPage, Integer pageSize, String acceptHeader);
}

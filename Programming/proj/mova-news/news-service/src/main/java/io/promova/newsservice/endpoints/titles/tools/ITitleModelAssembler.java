package io.promova.newsservice.endpoints.titles.tools;

import io.promova.newsservice.reps.TitleEntity;
import org.springframework.hateoas.EntityModel;

public interface ITitleModelAssembler
{
    EntityModel<TitleEntity> toModel(TitleEntity title, boolean areLinksEnabled, Integer pageSize);
}

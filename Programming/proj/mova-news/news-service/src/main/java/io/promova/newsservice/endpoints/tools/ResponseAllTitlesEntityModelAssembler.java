package io.promova.newsservice.endpoints.tools;

import io.promova.newsservice.endpoints.entities.*;
import org.springframework.hateoas.EntityModel;

import java.util.Arrays;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

public class ResponseAllTitlesEntityModelAssembler implements IResponseAllTitlesEntityModelAssembler
{
    private ISingleTitleEntityModelAssembler modelAssembler;

    public ResponseAllTitlesEntityModelAssembler(ISingleTitleEntityModelAssembler modelAssembler)
    {
        this.modelAssembler = modelAssembler;
    }

    @Override
    public EntityModel<ResponseAllTitlesEntity> toModel(AllTitlesEntity entity)
    {

        return EntityModel.of(
                prepareResponse(entity)
//                linkTo(methodOn(TitleController.class).getAll()).withSelfRel()
        );
    }

    private ResponseAllTitlesEntity prepareResponse(AllTitlesEntity entity)
    {
        TitleEntity[] newsEntities = entity.getTitleEntities();
        List<EntityModel<TitleEntity>> entityModels = Arrays.stream(newsEntities).map(modelAssembler::toModel).toList();

        return new ResponseAllTitlesEntity(entityModels);
    }
}

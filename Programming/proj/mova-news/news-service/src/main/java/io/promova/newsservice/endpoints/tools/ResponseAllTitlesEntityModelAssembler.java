package io.promova.newsservice.endpoints.tools;

import io.promova.newsservice.endpoints.TitleController;
import io.promova.newsservice.endpoints.entities.*;
import org.springframework.hateoas.EntityModel;

import java.util.Arrays;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class ResponseAllTitlesEntityModelAssembler implements IResponseAllTitlesEntityModelAssembler
{
    private ISingleTitleEntityModelAssembler modelAssembler;

    public ResponseAllTitlesEntityModelAssembler(ISingleTitleEntityModelAssembler modelAssembler)
    {
        this.modelAssembler = modelAssembler;
    }

    @Override
    public EntityModel<ResponseAllTitlesEntity> toModel(AllTitlesEntity entity, boolean addLinks)
    {

        return EntityModel.of(
                prepareResponse(entity, addLinks)
//                linkTo(methodOn(TitleController.class).getPaged()).withSelfRel()
        );
    }

    private ResponseAllTitlesEntity prepareResponse(AllTitlesEntity entity, boolean addLinks)
    {
        TitleEntity[] newsEntities = entity.getTitleEntities();
        List<EntityModel<TitleEntity>> entityModels = Arrays.stream(newsEntities).map(
                (TitleEntity entity1) -> modelAssembler.toModel(entity1, addLinks)
        ).toList();

        return new ResponseAllTitlesEntity(entityModels);
    }
}

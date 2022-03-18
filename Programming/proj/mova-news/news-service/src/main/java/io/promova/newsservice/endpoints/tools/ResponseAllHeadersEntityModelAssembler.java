package io.promova.newsservice.endpoints.tools;

import io.promova.newsservice.endpoints.HeaderController;
import io.promova.newsservice.endpoints.entities.*;
import org.springframework.hateoas.EntityModel;

import java.util.Arrays;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class ResponseAllHeadersEntityModelAssembler implements IResponseAllHeadersEntityModelAssembler
{
    private ISingleHeaderEntityModelAssembler modelAssembler;

    public ResponseAllHeadersEntityModelAssembler(ISingleHeaderEntityModelAssembler modelAssembler)
    {
        this.modelAssembler = modelAssembler;
    }

    @Override
    public EntityModel<ResponseAllHeadersEntity> toModel(AllHeadersEntity entity)
    {

        return EntityModel.of(
                prepareResponse(entity),
                linkTo(methodOn(HeaderController.class).getAll()).withSelfRel()
        );
    }

    private ResponseAllHeadersEntity prepareResponse(AllHeadersEntity entity)
    {
        HeaderEntity[] newsEntities = entity.getHeaderEntities();
        List<EntityModel<HeaderEntity>> entityModels = Arrays.stream(newsEntities).map(modelAssembler::toModel).toList();

        return new ResponseAllHeadersEntity(entityModels);
    }
}

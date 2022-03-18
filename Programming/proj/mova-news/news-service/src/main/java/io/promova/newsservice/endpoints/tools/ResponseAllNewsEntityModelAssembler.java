package io.promova.newsservice.endpoints.tools;

import io.promova.newsservice.endpoints.NewsController;
import io.promova.newsservice.endpoints.entities.AllNewsEntity;
import io.promova.newsservice.endpoints.entities.ResponseAllNewsEntity;
import io.promova.newsservice.rep.NewsEntity;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

import java.util.Arrays;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class ResponseAllNewsEntityModelAssembler implements RepresentationModelAssembler<AllNewsEntity, EntityModel<ResponseAllNewsEntity>>
{
    private final SingleNewsModelAssembler modelAssembler;

    public ResponseAllNewsEntityModelAssembler(
            SingleNewsModelAssembler modelAssembler
    )
    {
        this.modelAssembler = modelAssembler;
    }

    @Override
    public EntityModel<ResponseAllNewsEntity> toModel(AllNewsEntity allNews)
    {
        return EntityModel.of(
                prepareResponse(allNews),
                linkTo(methodOn(NewsController.class).getAll()).withSelfRel()
        );
    }

    private ResponseAllNewsEntity prepareResponse(AllNewsEntity allNews)
    {
        NewsEntity[] newsEntities = allNews.getNewsEntities();
        List<EntityModel<NewsEntity>> entityModels = Arrays.stream(newsEntities).map(modelAssembler::toModel).toList();

        return new ResponseAllNewsEntity(entityModels);
    }
}

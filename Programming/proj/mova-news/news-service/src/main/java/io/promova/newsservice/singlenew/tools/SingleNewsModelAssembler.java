package io.promova.newsservice.singlenew.tools;

import io.promova.newsservice.rep.NewsEntity;
import io.promova.newsservice.singlenew.SingleNewsController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class SingleNewsModelAssembler implements RepresentationModelAssembler<NewsEntity, EntityModel<NewsEntity>>
{
    @Override
    public EntityModel<NewsEntity> toModel(NewsEntity employee)
    {

        return EntityModel.of(employee,
                linkTo(methodOn(SingleNewsController.class).getOne(employee.getId())).withSelfRel());
//                linkTo(methodOn(SingleNewsController.class).all()).withRel("employees"));
        // TODO: add all
    }
}

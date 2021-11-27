package me.thaithien.springtutorial.SpringLearningProject.restservice.controller;

import me.thaithien.springtutorial.SpringLearningProject.restservice.controller.KittenController;
import me.thaithien.springtutorial.SpringLearningProject.restservice.model.Kitten;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
class KittenModelAssembler implements RepresentationModelAssembler<Kitten, EntityModel<Kitten>> {

    @Override
    public EntityModel<Kitten> toModel(Kitten employee) {

        return EntityModel.of(employee, //
                linkTo(methodOn(KittenController.class).one(employee.getId())).withSelfRel(),
                linkTo(methodOn(KittenController.class).all()).withRel("employees"));
    }
}
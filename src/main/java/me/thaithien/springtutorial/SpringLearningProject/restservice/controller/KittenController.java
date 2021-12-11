package me.thaithien.springtutorial.SpringLearningProject.restservice.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import me.thaithien.springtutorial.SpringLearningProject.restservice.model.Greeting;
import me.thaithien.springtutorial.SpringLearningProject.restservice.model.Kitten;
import me.thaithien.springtutorial.SpringLearningProject.restservice.model.*;
import me.thaithien.springtutorial.SpringLearningProject.restservice.model.KittenRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class KittenController {
    private final KittenRepository repository;
    private final KittenModelAssembler assembler;

    public KittenController(KittenRepository repository, KittenModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/kittens/{id}")
    public EntityModel<Kitten> one(@PathVariable Long id) {

        Kitten cat = repository.findById(id)
                .orElseThrow(() -> new KittenNotFoundException(id));

        return assembler.toModel(cat);
    }

    @GetMapping("/kittens")
    public CollectionModel<EntityModel<Kitten>> all() {

        List<EntityModel<Kitten>> cats = repository.findAll().stream()
                .map(assembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(cats, linkTo(methodOn(KittenController.class).all()).withSelfRel());
    }

    @PostMapping("/kittens")
    Kitten newKitten(@RequestBody Kitten newKitten) {
        return repository.save(newKitten);
    }

    @PostMapping("/kittens/bydna")
    Kitten newKittenByDNA(@RequestParam("dna")  String dna) {
        Kitten kit = new Kitten();
        kit.setDna(dna);
        return repository.save(kit);
    }

}
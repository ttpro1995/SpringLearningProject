package me.thaithien.springtutorial.SpringLearningProject.restservice.controller;


class KittenNotFoundException extends RuntimeException {

    KittenNotFoundException(Long id) {
        super("Could not find kitten " + id);
    }
}
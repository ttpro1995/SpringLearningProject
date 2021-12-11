package me.thaithien.springtutorial.SpringLearningProject.restservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//
//@Entity

@Document(collection = "kittens")
public class Kitten {

    private @Id
    Long id;
    private String dna;

    public Kitten() {
    }

    @Transient
    public static final String SEQUENCE_NAME = "kittens_sequence";

    public Kitten(long id, String dna) {
        this.id = id;
        this.dna = dna;
    }


    public Kitten(String dna) {
        this.dna = dna;
    }

    public Long getId() {
        return this.id;
    }

    public String getDna() {
        return dna;
    }

    public void setDna(String dna) {
        this.dna = dna;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

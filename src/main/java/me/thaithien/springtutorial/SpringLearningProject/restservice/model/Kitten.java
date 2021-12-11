package me.thaithien.springtutorial.SpringLearningProject.restservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Kitten {

    private @Id @GeneratedValue
    Long id;
    private String dna;

    public Kitten() {
    }

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
}

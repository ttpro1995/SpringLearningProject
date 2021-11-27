package me.thaithien.springtutorial.SpringLearningProject.restservice.model;


import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Long is id type of Employee
 */
public interface KittenRepository extends JpaRepository<Kitten, Long> {

}
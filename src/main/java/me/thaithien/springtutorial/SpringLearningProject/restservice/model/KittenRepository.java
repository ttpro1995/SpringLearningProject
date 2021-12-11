package me.thaithien.springtutorial.SpringLearningProject.restservice.model;


// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Long is id type of Employee
 */
public interface KittenRepository extends MongoRepository<Kitten, Long> {

}
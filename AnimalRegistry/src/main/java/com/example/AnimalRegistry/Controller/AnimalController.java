package com.example.AnimalRegistry.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.AnimalRegistry.Entity.Animal;
import com.example.AnimalRegistry.Service.AnimalServices;

//import io.opentelemetry.instrumentation.annotations.WithSpan;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.lang.Iterable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




// This class is marked as a Spring RestController, indicating that it handles HTTP requests and serves as a part of the API.
@RestController

// The @Tag annotation is often used for API documentation, and it specifies the
// name of the tag for this controller.
@Tag(name = "Animal Registry API")

// The @CrossOrigin annotation allows cross-origin requests from any origin
// ("*").
// This is useful for enabling web clients from different domains to access this API.
@CrossOrigin("https://3000-pavisu-puvsws2324-f4kdj1cmbe2.ws-eu106.gitpod.io") // You can change here the URL of the frontend part

// The @RequestMapping annotation specifies the base URL path for this controller, which is "/api/v1/animal".
// All endpoints in this controller will be relative to this path.
@RequestMapping("/api/v1/animals")

// The controller is responsible for handling various HTTP requests related to
// animals in the API.
public class AnimalController {

    /*
     * This field is annotated with @Autowired, indicating that Spring should inject
     * an instance
     * of the AnimalServices bean into this field. AnimalServices likely provides
     * business logic
     * and services related to animals.
     */
    @Autowired
    private AnimalServices animalServices;
    
    private final Logger logger = LoggerFactory.getLogger(AnimalController.class);


    // Define a POST endpoint for saving an animal
    @NewSpan
    @PostMapping(value = "/")
    private ResponseEntity<String> saveAnimal(@RequestBody Animal animals) {
        logger.info("saveAnimal method called");
            // Call the saveorUpdate method from AnimalServices to save or update the animal
            animalServices.saveorUpdate(animals);

            // Return the unique identifier (animalid) of the saved animal
            return ResponseEntity.status(HttpStatus.CREATED).body(animals.getAnimalid());
       
    }

    // Define a GET endpoint for retrieving a list of all animals
    @NewSpan
    @GetMapping(value = "/")
    // The method returns an Iterable collection of Animal objects, representing a
    // list of all animals in the registry.
    public ResponseEntity<Iterable<Animal>> getAnimals() {
        logger.info("getAnimals method called");
        // Call the listAll method from AnimalServices to get all animals. This method
        // likely fetches and returns all animals from a data source (e.g., a database).
        Iterable<Animal> animals = animalServices.listAll();
        return ResponseEntity.ok(animals);
    }

    // Define a PUT endpoint for updating an existing animal by its ID
    @NewSpan
    @PutMapping(value = "/{id}")
    private ResponseEntity<Animal> update(@RequestBody Animal animal, @PathVariable(name = "id") String animalid) {
        logger.info("update method called");
        // Set the animal's ID based on the provided path variable
        animal.setAnimalid(animalid);

        // Call the saveorUpdate method from AnimalServices to update the animal
        animalServices.saveorUpdate(animal);

        // Return the updated animal
        return ResponseEntity.ok(animal);
    }

    // Define a DELETE endpoint for deleting an animal by its ID
    @NewSpan
    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteAnimal(@PathVariable("id") String animalid) {
        logger.info("deleteAnimal method called");
        // Call the deleteAnimal method from AnimalServices to delete the animal
        animalServices.deleteAnimal((animalid));
        return ResponseEntity.noContent().build();
    }

    // Define a GET endpoint for retrieving an animal by its ID
    @NewSpan
    @RequestMapping("/search/{id}")
    private ResponseEntity<Animal> getAnimal(@PathVariable(name = "id") String animalid) {
        logger.info("getAnimal method called");
        // Call the getAnimalById method from AnimalServices to retrieve the animal
        Animal animal = animalServices.getAnimalById(animalid);
        return ResponseEntity.ok(animal);
    }

}

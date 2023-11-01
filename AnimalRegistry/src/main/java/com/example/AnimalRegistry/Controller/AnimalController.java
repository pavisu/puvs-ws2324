package com.example.AnimalRegistry.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.AnimalRegistry.Entity.Animal;
import com.example.AnimalRegistry.Service.AnimalServices;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.lang.Iterable;



// This class is marked as a Spring RestController, indicating that it handles HTTP requests and serves as a part of the API.
@RestController
// The @Tag annotation is often used for API documentation, and it specifies the name of the tag for this controller.
@Tag(name = "Animal Registry API")
// The @CrossOrigin annotation allows cross-origin requests from any origin ("*"). 
// This is useful for enabling web clients from different domains to access this API.
@CrossOrigin(origins = "*")
// The @RequestMapping annotation specifies the base URL path for this controller, which is "/api/v1/animal". 
// All endpoints in this controller will be relative to this path.
@RequestMapping("api/v1/animal")
// The controller is responsible for handling various HTTP requests related to animals in the API.
public class AnimalController {
    
   /* This field is annotated with @Autowired, indicating that Spring should inject an instance 
   of the AnimalServices bean into this field. AnimalServices likely provides business logic 
   and services related to animals. */
   @Autowired
   private AnimalServices animalServices;

    // Define a POST endpoint for saving an animal
    @PostMapping(value="/save")
    private String saveAnimal(@RequestBody Animal animals){

        // Call the saveorUpdate method from AnimalServices to save or update the animal
        animalServices.saveorUpdate(animals);

        // Return the unique identifier (animalid) of the saved animal
        return animals.getAnimalid();
    }

    // Define a GET endpoint for retrieving a list of all animals
    @GetMapping(value="/allanimals")
    // The method returns an Iterable collection of Animal objects, representing a list of all animals in the registry.
    public Iterable<Animal> getAnimals(){

        // Call the listAll method from AnimalServices to get all animals. This method likely fetches and returns all animals from a data source (e.g., a database).
        return animalServices.listAll();
    }

    // Define a PUT endpoint for updating an existing animal by its ID
    @PutMapping(value="/edit/{id}")
    private Animal update(@RequestBody Animal animal,@PathVariable(name="id")String animalid){

        // Set the animal's ID based on the provided path variable
        animal.setAnimalid(animalid);

        // Call the saveorUpdate method from AnimalServices to update the animal
        animalServices.saveorUpdate(animal);

        // Return the updated animal
        return animal;
    }

    // Define a DELETE endpoint for deleting an animal by its ID
    @DeleteMapping("/delete/{id}")
    private void deleteAnimal(@PathVariable("id") String animalid){

        // Call the deleteAnimal method from AnimalServices to delete the animal
        animalServices.deleteAnimal((animalid));
    }

    // Define a GET endpoint for retrieving an animal by its ID
    @RequestMapping("/search/{id}")
    private Animal getAnimal(@PathVariable(name="id")String animalid){
        // Call the getAnimalById method from AnimalServices to retrieve the animal
        return animalServices.getAnimalById(animalid);
    }

}

package com.example.AnimalRegistry.Service;

import com.example.AnimalRegistry.Entity.Animal;
import com.example.AnimalRegistry.Repo.AnimalRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// This class is marked with the @Service annotation, indicating that it's a Spring service component, 
// responsible for providing business logic related to animals.
@Service
public class AnimalServices {
    
    // This field is annotated with @Autowired, indicating that Spring should inject an instance of the AnimalRepo repository into this field. 
    // The repository is used for database interactions with animal data.
    @Autowired
    private AnimalRepo repo;

    // This method allows saving or updating an animal record in the database.
    public void saveorUpdate(Animal animals){

        // It calls the "save" method on the "repo" (AnimalRepo) to save the provided "animals" object to the database.
        repo.save(animals);

    }

    // This method retrieves a list of all animal records from the database.
    public Iterable<Animal> listAll() {
                
        // It calls the "findAll" method on the "repo" to fetch all animal records and returns them as an iterable collection.
        return repo.findAll();
    }

    // This method allows deleting an animal record by its ID from the database.
    public void deleteAnimal(String id) {

        // It calls the "deleteById" method on the "repo" and provides the "id" parameter to delete the animal with the specified ID.
        repo.deleteById(id);
    }

    // This method retrieves an animal record by its ID from the database.
    public Animal getAnimalById(String animalid) {

        // It calls the "findById" method on the "repo" and provides the "animalid" parameter. 
        // The ".get()" method is used to extract and return the found animal object.
        return repo.findById(animalid).get();
    }

}

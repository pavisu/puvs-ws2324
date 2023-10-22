package com.example.AnimalRegistry.Service;

import com.example.AnimalRegistry.Entity.Animal;
import com.example.AnimalRegistry.Repo.AnimalRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnimalServices {
    
    @Autowired
    private AnimalRepo repo;

    public void saveorUpdate(Animal animals){

        repo.save(animals);

    }

    public Iterable<Animal> listAll() {
        return this.repo.findAll();
    }

    public void deleteAnimal(String id) {
        repo.deleteById(id);
    }

    public Animal getAnimalById(String animalid) {
        return repo.findById(animalid).get();
    }

}

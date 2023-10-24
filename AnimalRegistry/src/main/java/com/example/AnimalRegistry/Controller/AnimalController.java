package com.example.AnimalRegistry.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.AnimalRegistry.Entity.Animal;
import com.example.AnimalRegistry.Service.AnimalServices;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/animal")
public class AnimalController {
    
   @Autowired
   private AnimalServices animalServices;


    @PostMapping(value="/save")
    private String saveAnimal(@RequestBody Animal animals){


        animalServices.saveorUpdate(animals);
        return animals.getAnimalid();
    }

    @GetMapping(value="/allanimals")
    public Iterable<Animal> getAnimals(){

        return animalServices.listAll();
    }

    @PutMapping(value="/edit/{id}")
    private Animal update(@RequestBody Animal animal,@PathVariable(name="id")String animalid){

        animal.setAnimalid(animalid);
        animalServices.saveorUpdate(animal);
        return animal;
    }

    @DeleteMapping("/delete/{id}")
    private void deleteAnimal(@PathVariable("id") String animalid){
        
        animalServices.deleteAnimal((animalid));
    }


    @RequestMapping("/search/{id}")
    private Animal getAnimal(@PathVariable(name="id")String animalid){
        return animalServices.getAnimalById(animalid);
    }

}

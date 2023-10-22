package com.example.AnimalRegistry.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value= "/getAll")
    private Iterable<Animal>getAnimals(){


        return animalServices.listAll();
    }

    @PutMapping(value= "/edit/{id}")
    private Animal update(@RequestBody Animal animal,@PathVariable(name="id")String animalid){

        animal.setAnimalid(animalid);
        animalServices.saveorUpdate(animal);
        return animal;
    }

    @DeleteMapping("/delete/{id}")
    private void deleteAnimal(@PathVariable("id") String animalid){
        
        animalServices.deleteAnimal((animalid));
    }


    @RequestMapping("/animal/{id}")
    private Animal getAnimal(@PathVariable(name="id")String animalid){
        return animalServices.getAnimalById(animalid);
    }

}

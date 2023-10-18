package com.example.AnimalRegistry.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping(value= "/save")
    private String saveAnimal(@RequestBody Animal animals){


        animalServices.saveorUpdate(animals);
        return animals.get_id();
    }
}

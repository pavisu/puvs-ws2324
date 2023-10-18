package com.example.AnimalRegistry.Service;

import com.example.AnimalRegistry.Entity.Animal;
import com.example.AnimalRegistry.Repo.AnimalRepo;

import org.springframework.stereotype.Service;


@Service
public class AnimalServices {
    
    @Autowired
    private AnimalRepo repo;

    public void saveorUpdate(Animal animals){

        repo.save(animals);

    }

}

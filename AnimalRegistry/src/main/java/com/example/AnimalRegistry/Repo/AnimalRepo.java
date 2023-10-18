package com.example.AnimalRegistry.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.AnimalRegistry.Entity.Animal;

public interface AnimalRepo extends MongoRepository<Animal,String>{
    

}
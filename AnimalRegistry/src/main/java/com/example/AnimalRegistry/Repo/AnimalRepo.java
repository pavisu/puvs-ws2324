package com.example.AnimalRegistry.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnimalRepo extends MongoRepository<Animal,String>{
    

}
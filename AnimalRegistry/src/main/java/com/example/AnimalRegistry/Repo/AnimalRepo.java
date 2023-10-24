package com.example.AnimalRegistry.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.AnimalRegistry.Entity.Animal;

import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepo extends MongoRepository<Animal,String>{
    

}
package com.example.AnimalRegistry.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.AnimalRegistry.Entity.Animal;

import org.springframework.stereotype.Repository;

 
// The @Repository annotation is used to indicate that this interface is a Spring Data repository, which allows for database interactions.
@Repository
// This is an interface named "AnimalRepo" which serves as a repository for managing "Animal" entities.
// It extends the MongoRepository interface, which provides standard CRUD (Create, Read, Update, Delete) operations for working with MongoDB data.
// The generic type parameters specify that this repository deals with "Animal" entities, and the primary key of these entities is of type "String".
public interface AnimalRepo extends MongoRepository<Animal,String>{
    
    // This interface doesn't include any method declarations. However, Spring Data MongoDB will automatically provide the basic CRUD operations (e.g., save, findById, findAll, delete, etc.) based on the "Animal" entity's structure.
}


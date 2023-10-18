package com.example.AnimalRegistry.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "animals")
public class Animal {

    @Id
    private String animalid;
    private String animalname;
    private String animaladdress;
    private String phonenumber;


    public Animal(String id, String animalname, String animaladdress, String phonenumber) {
        this.id = id;
        this.animalname = animalname;
        this.animaladdress = animaladdress;
        this.phonenumber = phonenumber;
    }

    public Animal() {
        
    }
    


    @Override
    public String toString(){
        return "Animal{" +
        "id='" + id + '\'' +
        ", animalname='" + animalname + '\'' +
        ", animaladdress='" + animaladdress + '\'' +
        ", phonenumber='" + phonenumber + '\'' +
        '}';
    }


}

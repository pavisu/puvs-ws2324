package com.example.AnimalRegistry.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// This class is annotated with @Document, indicating that it's a MongoDB document 
// and specifying the collection name as "animals."
@Document(collection = "animals")
public class Animal {

    // The @Id annotation marks the "animalid" field as the primary key in the MongoDB document.
    @Id
    private String animalid;

    // This is a constructor that allows you to create an instance of the "Animal" class with values for all fields.

    public Animal(String animalid, String animalname, String animaladdress, String phonenumber) {
        this.animalid = animalid;
        this.animalname = animalname;
        this.animaladdress = animaladdress;
        this.phonenumber = phonenumber;
    }

     public Animal() {
        // This is a default no-argument constructor, which is required for some frameworks and libraries. It initializes an instance of "Animal" with default values.
    }


    // Getters and setters are provided for the "animalid" field to access and modify its value.

    public String getAnimalid() {
        return animalid;
    }

    public void setAnimalid(String animalid) {
        this.animalid = animalid;
    }


    // Getters and setters are provided for the "animalname" field.

    private String animalname;
    
    public String getAnimalname() {
        return animalname;
    }

    public void setAnimalname(String animalname) {
        this.animalname = animalname;
    }


    // Getters and setters are provided for the "animaladdress" field.

    private String animaladdress;
    
    public String getAnimaladdress() {
        return animaladdress;
    }

    public void setAnimaladdress(String animaladdress) {
        this.animaladdress = animaladdress;
    }


    // Getters and setters are provided for the "phonenumber" field.

    private String phonenumber;

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    
    // The toString() method is overridden to provide a custom string representation of the "Animal" object.
   @Override
    public String toString(){
        return "Animal{" +
        "animalid='" + animalid + '\'' +
        ", animalname='" + animalname + '\'' +
        ", animaladdress='" + animaladdress + '\'' +
        ", phonenumber='" + phonenumber + '\'' +
        '}';
    }
    


}

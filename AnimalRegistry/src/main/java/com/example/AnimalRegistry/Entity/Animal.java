package com.example.AnimalRegistry.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "animals")
public class Animal {

    @Id
    private String _id;
    private String animalname;
    private String animaladdress;
    private String phonenumber;


    public Animal(String _id, String animalname, String animaladdress, String phonenumber) {
        this._id = _id;
        this.animalname = animalname;
        this.animaladdress = animaladdress;
        this.phonenumber = phonenumber;
    }

    public Animal() {
        
    }
    
    public String getAnimalname() {
        return animalname;
    }
    public void setAnimalname(String animalname) {
        this.animalname = animalname;
    }
    public String getAnimaladdress() {
        return animaladdress;
    }
    public void setAnimaladdress(String animaladdress) {
        this.animaladdress = animaladdress;
    }
    public String getPhonenumber() {
        return phonenumber;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString(){
        return "Animal{" +
        "_id='" + _id + '\'' +
        ", animalname='" + animalname + '\'' +
        ", animaladdress='" + animaladdress + '\'' +
        ", phonenumber='" + phonenumber + '\'' +
        '}';
    }


}

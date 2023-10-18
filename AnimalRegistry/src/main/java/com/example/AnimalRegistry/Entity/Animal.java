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


    public String getAnimalid() {
        return animalid;
    }

    public void setAnimalid(String animalid) {
        this.animalid = animalid;
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

    public Animal(String id, String animalname, String animaladdress, String phonenumber) {
        this.animalid = id;
        this.animalname = animalname;
        this.animaladdress = animaladdress;
        this.phonenumber = phonenumber;
    }

    public Animal() {
        
    }
    


    @Override
    public String toString(){
        return "Animal{" +
        "id='" + animalid + '\'' +
        ", animalname='" + animalname + '\'' +
        ", animaladdress='" + animaladdress + '\'' +
        ", phonenumber='" + phonenumber + '\'' +
        '}';
    }


}

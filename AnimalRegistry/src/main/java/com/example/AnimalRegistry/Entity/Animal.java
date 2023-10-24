package com.example.AnimalRegistry.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "animals")
public class Animal {

    @Id
    private String animalid;
    
    public String getAnimalid() {
        return animalid;
    }

    public void setAnimalid(String animalid) {
        this.animalid = animalid;
    }


    private String animalname;
    
    public String getAnimalname() {
        return animalname;
    }

    public void setAnimalname(String animalname) {
        this.animalname = animalname;
    }


    private String animaladdress;
    
    public String getAnimaladdress() {
        return animaladdress;
    }

    public void setAnimaladdress(String animaladdress) {
        this.animaladdress = animaladdress;
    }


    private String phonenumber;

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Animal(String animalid, String animalname, String animaladdress, String phonenumber) {
        this.animalid = animalid;
        this.animalname = animalname;
        this.animaladdress = animaladdress;
        this.phonenumber = phonenumber;
    }

    public Animal() {}


    /*public String getAnimalid() {
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

*/
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

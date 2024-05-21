package com.example.adoption.animal;

import com.example.adoption.adopter.Adopter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.context.annotation.Profile;

@Profile("Inmemory")
public abstract class Animal {
    //@Override
   // String toString();

    public abstract String getName();

    public abstract void setName(String name);

    public abstract String getBreed();

    public abstract void setBreed(String breed);

    public abstract int getAge();

    public abstract void setAge(int age);



    public abstract void animalOwner(Adopter owner);

    //void soundAnimal();

    abstract String soundAnimal();

    public abstract void setId(int anInt);

}

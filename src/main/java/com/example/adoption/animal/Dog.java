package com.example.adoption.animal;

import org.springframework.context.annotation.Profile;

@Profile("Inmemory")
public class Dog extends AnimalImpl {

    public Dog() {
    }

    public Dog(String name, String breed, int age) {
        super( name, breed, age);
    }
    @Override
    public String  soundAnimal() {

        //System.out.println(getName() + " is bark");
        return getName() +" is bark";

    }

}

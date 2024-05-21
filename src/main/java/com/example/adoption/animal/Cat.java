package com.example.adoption.animal;

import org.springframework.context.annotation.Profile;

@Profile("Inmemory")
public class Cat extends AnimalImpl {

    public Cat() {
    }

    public Cat(String name, String breed, int age) {

        super( name, breed, age);
    }
    @Override
    public String soundAnimal() {
        //super.soundAnimal();
        //System.out.println(getName()+ " is Meow");
        return getName() + " is Meow";
    }
}

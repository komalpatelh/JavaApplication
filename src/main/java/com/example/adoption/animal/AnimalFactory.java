package com.example.adoption.animal;

import com.example.adoption.dto.AnimalRequest;
import org.springframework.context.annotation.Profile;

@Profile("Inmemory")
public class AnimalFactory {

    public static Animal createAnimal(AnimalRequest animalRequest)
    {
        var animal =  switch (animalRequest.type()){
            case "dog" -> new Dog();
            case  "cat" -> new Cat();
            default ->  throw new IllegalArgumentException();
        };

        animal.setName( animalRequest.name());
        animal.setBreed(animalRequest.breed());
        animal.setAge(animalRequest.age());

        return animal;
    }

    public static Animal updateAnimal(AnimalRequest animalRequest)
    {
        var animal =  switch (animalRequest.type()){
            case "dog" -> new Dog();
            case  "cat" -> new Cat();
            default ->  throw new IllegalArgumentException();
        };

        animal.setName( animalRequest.name());
        animal.setBreed(animalRequest.breed());
        animal.setAge(animalRequest.age());

        return animal;
    }
}

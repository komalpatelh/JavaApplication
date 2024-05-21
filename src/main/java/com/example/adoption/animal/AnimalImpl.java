package com.example.adoption.animal;

import com.example.adoption.adopter.Adopter;

import com.example.adoption.adopter.AdopterImpl;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.context.annotation.Profile;

@Profile("Inmemory")
public class AnimalImpl extends Animal{

    private int id;
    private String name;
    private String breed;
    private int age;
    private String type;
    @ManyToOne
    private Adopter owner;
    // specifing the type object
    // access -> type -> name

    // The most common use of this keyword is to eliminate the confusion between class attribute and parameters with the same name
/*    public AbstractAnimal(int id, String name, String breed, int age) {
        super();
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.age = age;

    }*/

    public AnimalImpl() {
    }

    public AnimalImpl(String name, String breed, int age) {
        setName(name);
        setBreed(breed);
        setAge(age);

/*        this.name = name;
        this.breed = breed;
        this.age = age;*/

    }

    public void animalOwner(Adopter owner){
        this.owner = owner;
    }

    public String soundAnimal(){
        //System.out.println("Animal Move");
        return "Animal Move";
    }

    @Override
    public void setId(int anInt) {
        id = anInt;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "{ id=" + id +
                " name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if(name == null) {
            throw new IllegalArgumentException("Argument name: cant be null");
        } else if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Argument name: name can't be empty or blank string");
        }
        this.name = name;
    }

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public void setBreed(String breed) {
        if(breed == null) {
            throw new IllegalArgumentException("Argument name: cant be null");
        } else if (breed.trim().isEmpty()) {
            throw new IllegalArgumentException("Argument name: name can't be empty or blank string");
        }
        this.breed = breed;
    }

    @Override
    public int getAge() {

        return age;
    }

    @Override
    public void setAge(int age) {
        if ( age == 0 ){
            throw new IllegalArgumentException("Argument name: Cant be null or zero");
        }
        this.age = age;
    }



}

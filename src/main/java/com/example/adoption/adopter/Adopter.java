package com.example.adoption.adopter;

import com.example.adoption.animal.Animal;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;
@Profile("Inmemory")

public abstract class Adopter {

    public abstract int getId();

    public abstract void setId(int id);

    public abstract String getName();

    public abstract void setName(String name);

    public abstract String getPhoneNumber();

    abstract void setPhoneNumber(String phoneNumber);

   public abstract String getEmail();

    abstract void setEmail(String email);

    abstract void adoptAnimal(Animal animal);

    //abstract String toString();

    public abstract List<Animal> animals();
}

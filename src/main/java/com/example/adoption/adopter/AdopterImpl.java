package com.example.adoption.adopter;

import com.example.adoption.animal.Animal;
import com.example.adoption.animal.AnimalImpl;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;

@Profile("Inmemory")
public class AdopterImpl extends Adopter {


    private int id;
    private String name;
    private String phoneNumber;
    private String email;


    @OneToMany
    private final List<Animal> adoptanimals = new ArrayList<>();

    public AdopterImpl(){}
    public AdopterImpl(int id, String name, String phoneNumber, String email) {
        this.id = id;
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
//        this.name = name;
//        this.phoneNumber = phoneNumber;
//        this.email = email;

    }

    public AdopterImpl(String name, String phoneNumber, String email) {
//        this.name = name;
//        this.phoneNumber = phoneNumber;
//        this.email = email;
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
    }

    @Override
    public void adoptAnimal(Animal animal) {
        //what this method to
        adoptanimals.add(animal);
        animal.animalOwner(this);
        System.out.println(name + " has adopted " + animal.getName());
    }
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        if ( id == 0 ){
            throw new IllegalArgumentException("Argument name: Cant be null or zero");
        }
        this.id = id;
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
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        boolean Patternflag;
        String phonePattern = "\\d{3}-\\d{3}-\\d{4}";
        Patternflag = phoneNumber.matches(phonePattern);
        if (!Patternflag){
            throw new IllegalArgumentException("Argument name: Phone Pattern is incorrect");
        }
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", animal='" + getAdoptanimals() + '\'' +
                '}';
    }

    @Override
    public List<Animal> animals() {
        return adoptanimals;
    }

    public List<Animal> getAdoptanimals() {
        return adoptanimals;
    }

 /*   public void setAdoptanimals(List<Animal> adoptanimals) {
        this.adoptanimals = adoptanimals;
    }*/
}

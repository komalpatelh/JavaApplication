package com.example.adoption.dto;

import com.example.adoption.adopter.Adopter;
import com.example.adoption.adopter.AdopterImpl;
import com.example.adoption.animal.Animal;
import com.example.adoption.animal.AnimalFactory;
import com.example.adoption.animal.Dog;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.context.annotation.Profile;

import java.util.List;
@Profile("Inmemory")
public record AdopterRequest(
        @NotBlank String name,
        @NotBlank String phoneNumber,
        @Email String email,
        @NotNull List<AnimalRequest> animals) {


    public AdopterImpl createAdopter(){
        var adopter =  new AdopterImpl(
             0,
                name(),
                phoneNumber(),
                email());

        adopter.getAdoptanimals().addAll(
                animals().stream()
                        .map(AnimalFactory::createAnimal)
                        .toList()
        );
        return adopter;
    }

    public AdopterImpl updateAdopter() {
        var adopter =  new AdopterImpl(
                0,
                name(),
                phoneNumber(),
                email());

        adopter.getAdoptanimals().addAll(
                animals().stream()
                        .map(AnimalFactory::updateAnimal)
                        .toList()
        );
        return adopter;
    }

//    public Adopter updatedAdopter() {
//
//        var adopter =  new AdopterImpl(
//                0,
//                name(),
//                phoneNumber(),
//                email());
//
//        adopter.getAdoptanimals().addAll(
//                animals().stream()
//                        .map(AnimalFactory::createAnimal)
//                        .toList()
//        );
//        return adopter;
//    }
}

package com.example.adoption.dto;

import com.example.adoption.animal.Animal;
import org.springframework.context.annotation.Profile;

@Profile("Inmemory")
public record AnimalRequest(
        String name,
        String breed,
        int age,
        String type) {
}

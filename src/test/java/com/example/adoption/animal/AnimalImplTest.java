package com.example.adoption.animal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class AnimalImplTest {


    @Test
    @DisplayName("Test Breed Name")
    void testGetBreed() {
        Animal animal = new Dog("Ozzy", "German Shepherd", 7);
        String breedName = animal.getBreed();
        assertEquals("German Shepherd",breedName);
    }
    @Test
    @DisplayName("Test Pet Age")
    void testGetAge() {
        Animal animal = new Dog("Ozzy", "German Shepherd", 7);
        int age = animal.getAge();
        assertEquals(7,age);
    }
    @Test
    @DisplayName("Test Pet Name")
    void testPetName() {
        Animal animal = new Dog("Ozzy", "German Shepherd", 7);
        String name = animal.getName();
        assertEquals("Ozzy",name);
    }


}
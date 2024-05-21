package com.example.adoption.animal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DogTest {

    @Test
    void testSoundAnimal() {
        Animal animal = new Dog("Ozzy","German",8);
        String dogSound = animal.soundAnimal();
        assertEquals("Ozzy is bark" , dogSound);
    }

    @Test
    void testSoundAnimalNotADog(){
        Animal objectNotADog = new AnimalImpl("Fred2", "Not Siames", 80);
        String response = objectNotADog.soundAnimal();
        assertNotEquals("Fred2 is bark", response);
    }

}
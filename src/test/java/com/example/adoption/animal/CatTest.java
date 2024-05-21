package com.example.adoption.animal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CatTest {

    @Test
    void testSoundAnimal() {

        Animal animal = new Cat("Soju", "American Curl Cat", 5);
        String name = animal.soundAnimal();
        assertEquals("Soju is Meow", name);


    }
}
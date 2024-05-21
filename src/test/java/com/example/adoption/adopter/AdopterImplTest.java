package com.example.adoption.adopter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdopterImplTest {

    @Test
    @DisplayName("Adopter Name")
    void testAdopterName() {
        AdopterImpl adopter = new AdopterImpl("Komal", "732-874-4554","komalhpatel87@gmail.com");
        String adopterName = adopter.getName();
        assertEquals("Komal",adopterName);
    }
    @Test
    @DisplayName("Adopter PhoneNumber")
    void testAdopterPhoneNumber() {
        AdopterImpl adopter = new AdopterImpl("Komal", "732-874-4554","komalhpatel87@gmail.com");
        String adopterPhoneNumber = adopter.getPhoneNumber();
        assertEquals("732-874-4554",adopterPhoneNumber);
    }
    @Test
    @DisplayName("Adopter Email Address")
    void testAdopterEmailAddress() {
        AdopterImpl adopter = new AdopterImpl("Komal", "732-874-4554","komalhpatel87@gmail.com");
        String adopterEmail = adopter.getEmail();
        assertEquals("komalhpatel87@gmail.com",adopterEmail);
    }



}
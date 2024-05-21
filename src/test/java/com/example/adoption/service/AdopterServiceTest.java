package com.example.adoption.service;

import com.example.adoption.adopter.Adopter;
import com.example.adoption.adopter.AdopterImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ActiveProfiles("test")
@SpringBootTest
class AdopterServiceTest {

    @Autowired
    private AdopterService adopterService;


    @Test
    @DisplayName("Test Get All Adopters")
    void testGetAllAdopters() {
        List<Adopter> adopters = adopterService.getAllAdopters();
        assertEquals(1, adopters.size());
        Adopter adopter = new AdopterImpl("Krishna","914-329-6232","komalhpatel871@gmail.com");
        adopterService.addAdopter(adopter);


        Adopter adopter1 = new AdopterImpl("Ishan","914-329-6234","komalhpatel8713@gmail.com");
        adopterService.addAdopter(adopter1);
        //List<Adopter> adopters = adopterService.getAllAdopters();
        adopters = adopterService.getAllAdopters();
        adopters.forEach(System.out::println);

        assertEquals(3,adopters.size());


    }

    @Test
    @DisplayName("Test Delete Existing Adopter")
    void testDeleteExistingAdopter() {

        Adopter adopter = new AdopterImpl("Roma","914-329-6234","komalhpatel8713@gmail.com");
        Adopter newAdopter = adopterService.addAdopter(adopter);
        System.out.println(newAdopter);
        System.out.println(newAdopter.getId());
        boolean result = adopterService.deleteAdopter(1);
        assertTrue(result);
        //assertFalse(result);
        newAdopter = adopterService.getAdopter(1);
        assertNull(newAdopter);
    }

    @Test
    @DisplayName("Test Update Existing Adopter")
    void testUpdateExistingAdopter() {

        Adopter adopter = new AdopterImpl("Roma", "732-874-3553", "komalhpatel87@gmail.com");
        Adopter newAdopter = adopterService.addAdopter(adopter);
        System.out.println(newAdopter);
        //assertTrue(newAdopter.getName().contains("Krishna"));

        newAdopter.setName("Hamel");
        System.out.println(newAdopter);
        boolean result = adopterService.updateAdopter(newAdopter);

        assertTrue(result);

        newAdopter = adopterService.getAdopter(2);
        System.out.println(newAdopter);
        assertEquals("Hamel", newAdopter.getName());

    }

    @Test
    @DisplayName("Test Update NonExisting Adopter")
    void testUpdateNonExistingAdopter() {

        Adopter adopter = new AdopterImpl("Roma", "732-874-3553", "komalhpatel87@gmail.com");
        Adopter newAdopter = adopterService.addAdopter(adopter);
        System.out.println(newAdopter);


        newAdopter.setId(999);
        System.out.println(newAdopter);
        boolean result = adopterService.updateAdopter(newAdopter);

        assertFalse(result);

    }
    @Test
    @DisplayName("Test Delete NonExisting Adopter")
    public void testDeleteNonExistingAdopter() {

        boolean result = adopterService.deleteAdopter(999);
        assertFalse(result);
    }

}
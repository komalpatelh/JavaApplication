package com.example.adoption.dao.jpa;

import com.example.adoption.adopter.Adopter;
import com.example.adoption.adopter.AdopterImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ActiveProfiles("test")
@SpringBootTest
class JPAAdopterDAOTest {

    private JPAAdopterDAO jpaAdopterDAO;

    @BeforeEach
    public void init() {
        jpaAdopterDAO = new JPAAdopterDAO();
    }

    @Test
    @DisplayName("Test Find Adopter")
    void testFindAllPerson() {

        List<Adopter> adopters = jpaAdopterDAO.findAllPerson();
        System.out.println(adopters);
        assertEquals(1, adopters.size());
        Adopter adopter = new AdopterImpl("Komal", "732-874-4554","komalhpatel87@gmail.com");
        jpaAdopterDAO.insert(adopter);

        adopters = jpaAdopterDAO.findAllPerson();
        assertEquals(1, adopters.size());
    }



    @Test
    @DisplayName("Test Get Adopter WithExisting Id")
    void testGetAdopterWithExistingId() {
        Adopter adopter = new AdopterImpl("Komal", "732-874-4554","komalhpatel87@gmail.com");;
        assertEquals(0, adopter.getId());
        jpaAdopterDAO.insert(adopter);

        adopter = jpaAdopterDAO.findById(1);
        assertNotNull(adopter);
    }

    @Test
    @DisplayName("Test Insert Id")
    void testInsert() {
        Adopter adopter = new AdopterImpl("Komal", "732-874-4554","komalhpatel87@gmail.com");;
        assertEquals(0, adopter.getId());
        adopter = jpaAdopterDAO.insert(adopter);

        assertEquals(1, adopter.getId());
    }

    @Test
    @DisplayName("Test Find Id")
    void TestfindById() {
        Adopter adopter = jpaAdopterDAO.findById(1000);
        assertNull(adopter);
    }

    @Test
    @DisplayName("Test Update Name")
    void Testupdate() {
        int testId = 1;
        Adopter adopter = new AdopterImpl("Komal", "732-874-4554","komalhpatel87@gmail.com");;
        adopter = jpaAdopterDAO.insert(adopter);
        System.out.println(adopter);
        Adopter a = jpaAdopterDAO.findById(testId);
        assertNotNull(a);
        System.out.println(a);
        String newName = "Kelly";
        a.setName(newName);

        boolean result = jpaAdopterDAO.update(a);
        assertTrue(result);

        a = jpaAdopterDAO.findById(testId);
        assertEquals(newName, a.getName());
    }

    @Test
    @DisplayName("Test Delete")
    public void testDelete() {
        int testId = 1;
        Adopter adopter = new AdopterImpl("Komal", "732-874-4554","komalhpatel87@gmail.com");;
        adopter = jpaAdopterDAO.insert(adopter);

        Adopter adopter1 = jpaAdopterDAO.findById(testId);
        assertNotNull(adopter1);

        boolean result = jpaAdopterDAO.delete(testId);
        assertTrue(result);

        adopter1 = jpaAdopterDAO.findById(testId);
        assertNull(adopter1);
    }
}
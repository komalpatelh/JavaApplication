package com.example.adoption.db;

import com.example.adoption.adopter.Adopter;
import com.example.adoption.adopter.AdopterImpl;
import com.example.adoption.animal.Animal;
import com.example.adoption.animal.AnimalImpl;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

@SpringBootTest
public class JPADemo {

    @PersistenceContext
    private EntityManager em;

    @Test
    public void dumpAllAnimal(){


        TypedQuery<AnimalImpl> query = em.createQuery("select ae from AnimalImpl ae ", AnimalImpl.class);

        List<AnimalImpl> result = query.getResultList();
        out.println("result: " + result.size());
        result.forEach(out::println);
    }

}

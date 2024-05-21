package com.example.adoption.dao.jpa;

import com.example.adoption.adopter.Adopter;
import com.example.adoption.dao.AdopterDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Profile("Inmemory")
//@Profile({"dev", "test"})
public class JPAAdopterDAO implements AdopterDAO {


    private static final Map<Integer, Adopter> personMap = new HashMap<>();

    private int nextPerson = 1;
    //private AtomicInteger nextPerson = new AtomicInteger(1);

    @Override
    public Adopter insertPerson(Adopter addperson){
        int id = nextPerson++;
        addperson.setId(id);
        personMap.put(addperson.getId(),addperson);
        return addperson;
    }

    @Override
    public List<Adopter> findAllPerson() {
        return new ArrayList<>(personMap.values());

    }

    @Override
    public boolean delete(int id) {
        return personMap.remove(id) != null ;
    }

    @Override
    public Adopter insert(Adopter adopter) {
        //return null;
        int id = nextPerson++;
        adopter.setId(id);
        adopter.setName("JPA DAO: " + adopter.getName());
        personMap.put(adopter.getId(), adopter);

        return adopter;
    }

    @Override
    public Adopter findById(int id) {
        return personMap.get(id);
    }

    @Override
    public boolean update(Adopter adopter) {
        return personMap.replace(adopter.getId(), adopter) != null;
    }
}

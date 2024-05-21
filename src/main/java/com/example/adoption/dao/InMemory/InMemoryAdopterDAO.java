package com.example.adoption.dao.InMemory;

import com.example.adoption.adopter.Adopter;
import com.example.adoption.dao.AdopterDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
@Profile("Inmemory")
//@Profile(value = "prod")
public class InMemoryAdopterDAO implements AdopterDAO {

    public InMemoryAdopterDAO() {
        //this.nextPerson = nextPerson;
        System.out.println("InMemoryAdopterDAO");
    }

    //how to store the object.This is called dictionary
    private static Map<Integer, Adopter> personMap = new HashMap<>();
    private int nextPerson = 1;


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
        int id = nextPerson++;
        adopter.setId(id);
        adopter.setName("In Memory DAO: " + adopter.getName());
        personMap.put(adopter.getId(), adopter);

        return adopter;
    }

    @Override
    public Adopter findById(int id) {
        return personMap.get(id);

    }

    @Override
    public boolean update(Adopter adopter) {
        // Update which adopter???

        // update the map with the new person
        return personMap.replace(adopter.getId(), adopter) != null;
//        return false;
    }
}

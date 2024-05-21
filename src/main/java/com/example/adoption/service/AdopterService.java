package com.example.adoption.service;

import com.example.adoption.adopter.Adopter;
import com.example.adoption.dao.AdopterDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
@Profile("Inmemory")
@Service

public class AdopterService {

    @Autowired
    private AdopterDAO adopterDAO;
    private AtomicInteger betterCounter = new AtomicInteger(1);

    private Long id;


    public Adopter addAdopter(Adopter addperson) {
        return adopterDAO.insertPerson(addperson);
    }

    public Adopter getAdopter(int id) {
        return adopterDAO.findById(id);
    }

    public List<Adopter> getAllAdopters() {
        return adopterDAO.findAllPerson();
    }

    public boolean deleteAdopter(int id) {
        return adopterDAO.delete(id);
    }

    public boolean updateAdopter(Adopter adopter) {
        return adopterDAO.update(adopter);
    }


    public void setAdopterDAO(AdopterDAO adopterDAO) {
        this.adopterDAO = adopterDAO;
    }


    public Adopter createAdopter(Adopter adopter) {

        int a = 10;
//      int y = numCalls++;
        a++;
        int x = betterCounter.getAndIncrement();
        //Validate DOB
        //Other business logic

        //Save the student to a Store == what kind of store?
        Adopter insertedStudent = adopterDAO.insert(adopter);

        return insertedStudent;
        //Return a result

    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

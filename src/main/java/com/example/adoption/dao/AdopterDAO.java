package com.example.adoption.dao;

import com.example.adoption.adopter.Adopter;

import java.util.List;

public interface AdopterDAO {


    Adopter insertPerson(Adopter addperson);



    List<Adopter> findAllPerson();

    boolean delete(int id);

    Adopter insert(Adopter adopter);

    Adopter findById(int id);

    boolean update(Adopter adopter);
}

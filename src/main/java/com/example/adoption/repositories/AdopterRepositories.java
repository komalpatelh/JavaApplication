package com.example.adoption.repositories;

import com.example.adoption.domain.JPAAdopter;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Profile("prod")
@Repository
public interface AdopterRepositories extends CrudRepository<JPAAdopter, Integer> {
}

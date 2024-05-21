package com.example.adoption.controller;

import com.example.adoption.adopter.Adopter;
import com.example.adoption.dto.AdopterRequest;
import com.example.adoption.service.AdopterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Profile("Inmemory")
@RestController //This makes it a Spring bean and will make Spring Web MVC see it as a controller class
@RequestMapping("/adopters") //Adding this annotation we don't need to add path for each mapping
public class AdopterServiceController {

    @Autowired
    private AdopterService adopterService;

    @GetMapping("/hello") // What was the URL of the request
    public String sayHello() {
        return "Here we go with the Spring Boot";

    }

    @GetMapping
    public List<Adopter> getAll(){
        List<Adopter> adopters = adopterService.getAllAdopters();
        return adopters;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Adopter> getAdopter(@PathVariable("id") int id){
        System.out.println(id);
        Adopter adopter = adopterService.getAdopter(id);

        if(adopter == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }
        return ResponseEntity.ok(adopter);

    }

    @PostMapping
    public ResponseEntity<Adopter>  addAdopter(@RequestBody AdopterRequest adopter){
        Adopter newAdopter = adopterService.createAdopter(adopter.createAdopter());
            //return newAdopter;
        return ResponseEntity.ok(newAdopter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdopter(@PathVariable("id") int id){

        boolean adopter = adopterService.deleteAdopter(id);
        if(!adopter){
           // return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Adopter with id " + id);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();

    }
//  PUT localhost:8080/adopter/2
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAdopter(
            @PathVariable("id") int id,
            @Valid @RequestBody AdopterRequest adopter){

        System.out.println(id);
        Adopter adopter1 = adopterService.getAdopter(id);

        if(adopter1 == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Adopter with id " + id);
        }
        var finalAdopter = adopter.createAdopter();
        finalAdopter.setId(id);
        adopterService.updateAdopter(finalAdopter);

        return ResponseEntity.ok(finalAdopter);

    }

}

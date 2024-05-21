package com.example.adoption.controller;

import com.example.adoption.adopter.Adopter;
import com.example.adoption.adopter.AdopterImpl;
import com.example.adoption.service.AdopterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@AutoConfigureMockMvc
@WebMvcTest(controllers = AdopterServiceController.class)

class AdopterServiceControllerTest {

    @Autowired
    private MockMvc mockmvc;


    @MockBean
    private AdopterService adopterService;

    @Test

    void testGetAllAdopters() throws Exception{

        List<Adopter> adopters = new ArrayList<>();
        adopters.add(new AdopterImpl( "Fred", "111-222-3333", "fred.lname@email.com"));
        adopters.add(new AdopterImpl( "Wilma", "111-222-3333", "wilma.lname@email.com"));
        adopters.add(new AdopterImpl( "Wilma", "111-222-3333", "wilma.lname@email.com"));

        when(adopterService.getAllAdopters()).thenReturn(adopters);


        mockmvc.perform(MockMvcRequestBuilders
                        .get("/adopters")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
                //.andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1));
        //.get("/api/v1/adopters")


    }

    @Test
    void testGetAdopterId() throws Exception {
        List<Adopter> adopters = new ArrayList<>(); // create the empty array list
        Adopter adopter1 = new AdopterImpl(1,"Test1","111-222-3333","test1@gmail.com");
        Adopter adopter2 = new AdopterImpl(2,"Test2","111-222-3333","test2@gmail.com");
        adopters.add(adopter1);
        adopters.add(adopter2);

        System.out.println(adopters.getFirst());
        when(adopterService.getAdopter(3)).thenReturn(null);

        mockmvc.perform(MockMvcRequestBuilders
                .get("/adopters/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));

    }
    @Test
    void testGetAdopterGoodId() throws Exception {
        List<Adopter> adopters = new ArrayList<>(); // create the empty array list
        Adopter adopter1 = new AdopterImpl(1,"Test1","111-222-3333","test1@gmail.com");
        Adopter adopter2 = new AdopterImpl(2,"Test2","111-222-3333","test2@gmail.com");
        adopters.add(adopter1);
        adopters.add(adopter2);

        System.out.println(adopters.getFirst());
        when(adopterService.getAdopter(1)).thenReturn(adopters.getFirst());

        mockmvc.perform(MockMvcRequestBuilders
                        .get("/adopters/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));

    }

    @Test
    void testAddAdopter() throws Exception {

        Adopter adopter = new AdopterImpl(1,"Test1","111-222-3333","test1@gmail.com");
        System.out.println(adopter);
        when(adopterService.addAdopter(adopter)).thenReturn(adopter);


        mockmvc.perform(MockMvcRequestBuilders
                    .get("/adopters")
                    .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON));


    }

    @Test
    void testDeleteAdopterWithId() throws Exception {

        Adopter adopter = new AdopterImpl(2,"Test1","111-222-3333","test1@gmail.com");
        System.out.println(adopter);

        when(adopterService.deleteAdopter(2)).thenReturn(true);


        mockmvc.perform(MockMvcRequestBuilders
                .get("/adopters/2")
                .contentType((MediaType.APPLICATION_JSON)))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

    }

    @Test
    void updateAdopter() {
        Adopter adopter = new AdopterImpl(1,"Test1","111-222-3333","test1@gmail.com");
        System.out.println(adopter);
    }
}
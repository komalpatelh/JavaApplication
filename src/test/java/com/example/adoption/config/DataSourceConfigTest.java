package com.example.adoption.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@Profile("!test")
public class DataSourceConfigTest {

    @Bean
    @Primary
        //Create a method that returns the datasource
        //setup connection
        //create an instance of the DriverManagementDataSource
    DataSource Adoptionapp(){
        return new DriverManagerDataSource(
                "jdbc:postgresql://localhost:5433/adoptapp",
                "larku",
                "larku"
        );

    }
}

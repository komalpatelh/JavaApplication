package com.example.adoption.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
@Profile("test")
public class DataSourceConfig {

    @Bean
//		Create a method that returns the datasource
//		setup connection
//		create an instance of the DriverManagementDataSource
    DataSource Adoptionapptest(){
        return new DriverManagerDataSource(
                "jdbc:h2:mem:~/adoptapp",
                "sa",
                ""
        );

    }
}

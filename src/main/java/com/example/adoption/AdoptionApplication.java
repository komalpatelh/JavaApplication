package com.example.adoption;

import com.example.adoption.adopter.Adopter;
import com.example.adoption.adopter.AdopterImpl;
import com.example.adoption.animal.AnimalImpl;
import com.example.adoption.animal.Cat;
import com.example.adoption.animal.Dog;
import com.example.adoption.db.JDBCTemplateDemo;
import com.example.adoption.service.AdopterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.util.List;

import static java.lang.System.out;

@SpringBootApplication
public class AdoptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdoptionApplication.class, args);
	}
}

	//@Profile("!test")
	@Component
	class MyRunner implements CommandLineRunner {

//	@Autowired
//	private JDBCTemplateDemo jdbcTemplateDemo;

		@Override
		public void run(String... args) throws Exception {

//			List<Adopter> adopters = jdbcTemplateDemo.findAllAdopter();
//			adopters.forEach(out::println);
//			out.println("-=-=-=-==-=-=-=-=-=-");
//
//			//create a obj of type adopter impl
//			AdopterImpl adopter = new AdopterImpl("Arjun","863-396-5365","Arjun@gmail.com");
//			adopter.animals().add(new Cat("Oimi","German1",10));
//			//jdbcTemplateDemo.insertAdopter(new AdopterImpl("Himanshu","863-397-5355","himanshu@gmail.com"));
//			jdbcTemplateDemo.insertAdopter(adopter);
//
//			adopters = jdbcTemplateDemo.findAllAdopter();
//			adopters.forEach(out::println);

		}


//		@Autowired
//		private AdopterService adopterService;
//
//		@Override
//		public void run(String... args) throws Exception {
//
//
//		Adopter person1 = new AdopterImpl("Komal", "732-874-4554", "komalhpatel87@gmail.com");
//		Adopter person2 = new AdopterImpl("Hamel", "732-874-4554", "komalhpatel87@gmail.com");
//
//
//		AnimalImpl animal1 = new Dog("Ozzy", "German Shepherd", 7);
//		AnimalImpl animal2 = new Cat("Soju", "American Curl Cat", 5);
//
//
//		adopterService.addAdopter(person1).adoptAnimal(animal1);
//			// Stored response in a variable
//		String response = animal1.soundAnimal();
//		System.out.println(response);
//		System.out.println("She is " + animal1.getBreed() + " and her age is " + animal1.getAge() );
//		adopterService.addAdopter(person2).adoptAnimal(animal2);
//		// Printed Response directly to terminal
//		System.out.println(animal2.soundAnimal());
//		List<Adopter> adopters = adopterService.getAllAdopters();
//			//System.out.println("Adopter: "+adopters.getLast());
//			out.println("result: " + adopters.size());
//			adopters.forEach(out::println);
//
//		}


	}



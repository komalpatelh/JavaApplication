package com.example.adoption.db;

import com.example.adoption.adopter.Adopter;
import com.example.adoption.adopter.AdopterImpl;
import com.example.adoption.animal.Animal;
import com.example.adoption.animal.Cat;
import com.example.adoption.animal.Dog;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Profile("Inmemory")
@Repository
//@Profile(value = {"test", "!test"})
public class JDBCTemplateDemo {
    //open the connection
    //query

    private final DataSource  source;

    //private int id;

    public JDBCTemplateDemo(DataSource source) {
        this.source = source;
    }


    public List<Adopter> findAllAdopter(){
        var adopterList = new ArrayList<Adopter>();
        //String sql = "Select * from adopter";
        String sql = """
                Select adopter.id,adopter.name as adopter,adopter.phonenumber,adopter.email
                       ,animal.animal_id,animal.name,animal.breed, animal.age, animal.type 
                       from adopter 
                left join animal 
                on  animal.adopter_id = adopter.id
            """;
        try(
                Connection findall = source.getConnection();
                PreparedStatement pStmt = findall.prepareStatement(sql);
                ResultSet rSet = pStmt.executeQuery();
        ){
            int lastId = -1;
            Adopter adopter = null; //Create Object "Not Initialized

            while (rSet.next()){

                if(lastId != rSet.getInt("id")){
                    //Different id, need to instantiate another object
                     lastId =  rSet.getInt("id");
                     adopter = new AdopterImpl(
                            rSet.getInt("id"),
                            rSet.getString("adopter"),
                            rSet.getString("phonenumber"),
                            rSet.getString("email")
                    );

                     adopterList.add(adopter);
                }
                //We cannot create objects from Abstract classes, but concrete classes
                  String type = rSet.getString("type");

                if(type != null) {
                    Animal animal = switch (type){
                        case "CAT" -> new Cat();
                        case "DOG" -> new Dog();
                        default -> throw new IllegalArgumentException();
                    };

                    animal.setId(rSet.getInt("animal_id"));
                    animal.setName(rSet.getString("name"));
                    animal.setAge(rSet.getInt("age"));
                    animal.setBreed(rSet.getString("breed"));
                    adopter.animals().add(animal);

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return adopterList;
    }


    public Adopter insertAdopter(Adopter adopter){
        //ar adopterList = new ArrayList<Adopter>();

        String sql = """
                INSERT INTO adopter (name, phonenumber,email)
                VALUES (?, ?, ?)
                """;
        try(
                Connection findall = source.getConnection();
                PreparedStatement pStmt = findall.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                //ResultSet rSet = pStmt.executeQuery();
        ){
            pStmt.setString(1, adopter.getName());
            pStmt.setString(2, adopter.getPhoneNumber());
            pStmt.setString(3, adopter.getEmail());
            pStmt.executeUpdate();

            try (ResultSet rSet = pStmt.getGeneratedKeys()){
                rSet.next();
                adopter.setId(rSet.getInt(1));
                insertAnimalsForAdopterId(adopter.getId(), adopter.animals());
            }

        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return adopter;
    }

    private void insertAnimalsForAdopterId(int id, List<Animal> animals) {
        String sqlAnimal = """
                INSERT INTO animal (name, breed ,age, type, adopter_id)
                VALUES (?, ?, ?, ?, ?)
                """;
        try(
                Connection findallAnimal = source.getConnection();
                PreparedStatement pStmt = findallAnimal.prepareStatement(sqlAnimal, Statement.RETURN_GENERATED_KEYS);
                //ResultSet rSet = pStmt.executeQuery();
        ){
            for (Animal animal : animals) {
                pStmt.setString(1, animal.getName());
                pStmt.setString(2, animal.getBreed());
                pStmt.setInt(3, animal.getAge());
                pStmt.setString(4, animal.getClass().getSimpleName().toUpperCase());
                pStmt.setInt(5,id);
                pStmt.executeUpdate();
                try (ResultSet rSet = pStmt.getGeneratedKeys()){
                    rSet.next();
                    animal.setId(rSet.getInt(1));
            }
        }

        } catch (SQLException e) {
            throw new RuntimeException();
        }

        //return animals;
    }

//    public List<Adopter> insertRecord(){
//        var adopterList = new ArrayList<Adopter>();
//
//        String sql = """
//                INSERT INTO adopter (name, phonenumber,email)
//                VALUES (?, ?, ?)
//                """;
//        try(
//                Connection findall = source.getConnection();
//                PreparedStatement pStmt = findall.prepareStatement(sql);
//                ResultSet rSet = pStmt.executeQuery();
//        ){
//
//            while (rSet.next()){
//
//                var adopter = new AdopterImpl(
//                        rSet.getInt("id"),
//                        rSet.getString("name"),
//                        rSet.getString("phonenumber"),
//                        rSet.getString("email")
//                );
//                adopterList.add(adopter);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return adopterList;
//    }

//    public List<Adopter> getAdopterWithOneColumn(){
//        var adopterList = new ArrayList<Adopter>();
//        //String sql = "Select * from adopter";
//        String sql = """
//                Select * from adopter where id = ?
//            """;
//        try(
//                Connection findall = source.getConnection();
//                PreparedStatement pStmt = findall.prepareStatement(sql);
//                ResultSet rSet = pStmt.executeQuery();
//        )
//    }
}

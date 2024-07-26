package com.agencia.persons.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.agencia.persons.domain.entity.Person;
import com.agencia.persons.domain.service.PersonService;

public class PersonRepository implements PersonService{
    private Connection connection;

    public PersonRepository(){

    try {
        Properties props = new Properties();
        props.load(getClass().getClassLoader().getResourceAsStream("configdb.properties"));
        String url = props.getProperty("url");
        String user = props.getProperty("user");
        String password = props.getProperty("password");

        System.out.println("URL: " + url); // Verificar la URL cargada
        System.out.println("User: " + user); // Verificar el usuario cargado
        // N
        connection = DriverManager.getConnection(url, user, password);
        System.out.println("Conexión exitosa!");    
    } catch (Exception e) {
        e.printStackTrace();
    }

}



    @Override
    public void createPerson(Person person) {
        
        try{
            String query= "INSERT INTO persons(name, lastname, idcity, address, age, email, idgender) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps=connection.prepareStatement(query,
            PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1,person.getName());
            ps.setString(2,person.getLastname());
            ps.setInt(3,person.getIdCity());
            ps.setString(4,person.getAddress());
            ps.setInt(5,person.getAge());
            ps.setString(6,person.getEmail());
            ps.setInt(7, person.getIdGender());

            ps.executeUpdate();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    person.setId(generatedKeys.getInt(1));
                }
            }
        }catch(SQLException e){
            e.printStackTrace();

        }


    }



    @Override
    public void updatePerson(Person person) {
            String query= "UPDATE persons SET name=?, lastname=?, idcity=?,  address=?, age=?, email=?, idgender=? WHERE id = ? ";
            

            try (PreparedStatement ps = connection.prepareStatement(query)) {

                ps.setString(1,person.getName());
                ps.setString(2,person.getLastname());
                ps.setInt(3,person.getIdCity());
                ps.setString(4,person.getAddress());
                ps.setInt(5,person.getAge());
                ps.setString(6,person.getEmail());
                ps.setInt(7, person.getIdGender());
                ps.setInt(8, person.getId());


                ps.executeUpdate();
    
                System.out.println("Persona actualizada correctamente. ");
            }catch (SQLException e) {
                e.printStackTrace();

            }

    
        

    }


    @Override
    public Person findPerson(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findPerson'");
    }



    @Override
    public void deletePerson(Person person) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePerson'");
    }



    @Override
    public Person deletePerson(int id) {
           String query = "Delete FROM persons WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }

        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }








 





}
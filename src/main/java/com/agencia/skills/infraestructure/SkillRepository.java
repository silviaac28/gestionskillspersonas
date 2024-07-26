package com.agencia.skills.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.agencia.skills.domain.entity.Skill;
import com.agencia.skills.domain.service.SkillService;

public class SkillRepository implements SkillService{
    private Connection connection;

    public SkillRepository(){

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
public void createSkill(Skill skill) {
    
    try{
        String query= "INSERT INTO skill(name) VALUES (?)";
        PreparedStatement ps=connection.prepareStatement(query,
        PreparedStatement.RETURN_GENERATED_KEYS);

        ps.setString(1,skill.getName());


        ps.executeUpdate();

        try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                skill.setId(generatedKeys.getInt(1));
            }
        }
    }catch(SQLException e){
        e.printStackTrace();

    }


}}

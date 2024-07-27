package com.agencia.personaskill.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.agencia.personaskill.domain.service.AsignarSkillService;
import com.agencia.skills.domain.entity.Skill;

public class AsignarSkillRepository implements AsignarSkillService{
    private Connection connection;

    public AsignarSkillRepository(){

    try {
        Properties props = new Properties();
        props.load(getClass().getClassLoader().getResourceAsStream("configdb.properties"));
        String url = props.getProperty("url");
        String user = props.getProperty("user");
        String password = props.getProperty("password");

        System.out.println("URL: " + url); 
        System.out.println("User: " + user); 
        // N
        connection = DriverManager.getConnection(url, user, password);
        System.out.println("Conexión exitosa!");    
    } catch (Exception e) {
        e.printStackTrace();
    }

}

    @Override
    public void asignarSkill(Skill skill) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asignarSkill'");
    }

}
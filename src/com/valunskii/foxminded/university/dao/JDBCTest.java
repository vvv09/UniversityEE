package com.valunskii.foxminded.university.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_NAME = "jdbc:postgresql://localhost:5432/foxuniversity";
    static final String USER = "postgres";
    static final String PASS = "1568996";
    
    public static void main(String[] args) {
            
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_NAME, USER, PASS);
            statement = connection.createStatement();
            String sql = "SELECT * FROM students";
            ResultSet resultSet = statement.executeQuery(sql);
            
            System.out.println("-= Список всех студентов =-");
            while(resultSet.next()) {
                int id = resultSet.getInt("student_id");
                String firstName = resultSet.getString("first_name");
                String middleName = resultSet.getString("middle_name");
                String lastName = resultSet.getString("last_name");
                int groupId = resultSet.getInt("group_id");
               
                System.out.print(id + ")");
                System.out.print(firstName + " ");
                System.out.print(middleName  + " ");
                System.out.print(lastName);
                System.out.println(", группа " + groupId);
            }
            
            resultSet.close();
            statement.close();
            connection.close();
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return;
        } 
        
        System.out.println("end");
    }
}

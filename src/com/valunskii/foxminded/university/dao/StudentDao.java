package com.valunskii.foxminded.university.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.valunskii.foxminded.university.domain.Student;
import com.valunskii.foxminded.university.domain.Teacher;

public class StudentDao {

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_NAME = "jdbc:postgresql://localhost:5432/foxuniversity";
    static final String USER = "postgres";
    static final String PASS = "1568996";

    public List<Student> getAllStudents() {
        List<Student> output = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_NAME, USER, PASS);
            statement = connection.createStatement();
            String sql = "SELECT * FROM students";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                output.add(new Student(resultSet.getInt("student_id"), resultSet.getString("first_name"), resultSet.getString("middle_name"), resultSet.getString("last_name")));
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {

            }
        }
        return output;
    }
}

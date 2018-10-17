package com.valunskii.foxminded.university.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.valunskii.foxminded.university.dao.executor.Executor;
import com.valunskii.foxminded.university.domain.Student;


public class StudentDao {
    private Executor executor;

    public StudentDao() {
        this.executor = new Executor();
    }

    public List<Student> getAll() throws SQLException{
        return executor.execQuery("select * from students", result -> {
            List<Student> list = new ArrayList<>(); 
            while(result.next()) {
            list.add(new Student(result.getInt("student_id"), result.getString("first_name"), result.getString("middle_name"), result.getString("last_name")));
            }
            return list;
        });
    }
    
    public Student get(int id) throws SQLException {
        return executor.execQuery("select * from public.students where student_id=" + id, result -> {
            result.next();
            return new Student(result.getInt("student_id"), result.getString("first_name"), result.getString("middle_name"), result.getString("last_name"));
        });
    }
    
    public void add(int id, String firstName, String middleName, String lastName) throws SQLException {
        executor.execUpdate("INSERT INTO students VALUES (" + id + ",'" + firstName + "','" + middleName + "','" + lastName + "');");
    }
    
    public void delete(int id) throws SQLException {
        executor.execUpdate("DELETE FROM students WHERE student_id = " + id);
    }
}

package com.valunskii.foxminded.university.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.valunskii.foxminded.university.dao.executor.Executor;
import com.valunskii.foxminded.university.domain.Teacher;

public class TeacherDao {
    private Executor executor;

    public TeacherDao() {
        this.executor = new Executor();
    }

    public List<Teacher> getAll() throws SQLException{
        return executor.execQuery("select * from teachers", result -> {
            List<Teacher> list = new ArrayList<>(); 
            while(result.next()) {
            list.add(new Teacher(result.getInt("teacher_id"), result.getString("first_name"), result.getString("middle_name"), result.getString("last_name")));
            }
            return list;
        });
    }
    
    public Teacher get(int id) throws SQLException {
        return executor.execQuery("select * from teachers where teacher_id=" + id, result -> {
            result.next();
            return new Teacher(result.getInt("teacher_id"), result.getString("first_name"), result.getString("middle_name"), result.getString("last_name"));
        });
    }
    
    public void add(int id, String firstName, String middleName, String lastName) throws SQLException {
        executor.execUpdate("INSERT INTO teachers VALUES (" + id + ",'" + firstName + "','" + middleName + "','" + lastName + "');");
    }
    
    public void delete(int id) throws SQLException {
        executor.execUpdate("DELETE FROM teachers WHERE teacher_id = " + id);
    }
}

package com.valunskii.foxminded.university.repository.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.valunskii.foxminded.university.repository.entity.Teacher;
import com.valunskii.foxminded.university.repository.executor.Executor;

public class TeacherDao {
    private static Logger log = Logger.getLogger(TeacherDao.class);
    private Executor executor = new Executor();

    public List<Teacher> getAll() throws SQLException{
        log.info("Looking for teacher list");
        return executor.execQuery("select * from teachers", result -> {
            List<Teacher> list = new ArrayList<>(); 
            while(result.next()) {
            list.add(new Teacher(result.getInt("teacher_id"), result.getString("first_name"), result.getString("middle_name"), result.getString("last_name")));
            }
            log.info("Return teacher list");
            return list;
        });
    }
    
    public Teacher get(int id) throws SQLException {
        log.info("Looking for teacher with id = " + id);
        return executor.execQuery("select * from teachers where teacher_id=" + id, result -> {
            result.next();
            log.info("Return teacher");
            return new Teacher(result.getInt("teacher_id"), result.getString("first_name"), result.getString("middle_name"), result.getString("last_name"));
        });
    }
    
    public void add(int id, String firstName, String middleName, String lastName) throws SQLException {
        log.info("Add new teacher");
        executor.execUpdate("INSERT INTO teachers VALUES (" + id + ",'" + firstName + "','" + middleName + "','" + lastName + "');");
        log.info("Teacher added");
    }
    
    public void delete(int id) throws SQLException {
        log.info("Delete teacher");
        executor.execUpdate("DELETE FROM teachers WHERE teacher_id = " + id);
        log.info("Teacher deleted");
    }
}

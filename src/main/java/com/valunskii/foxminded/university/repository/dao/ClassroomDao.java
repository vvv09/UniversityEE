package com.valunskii.foxminded.university.repository.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.valunskii.foxminded.university.repository.entity.Classroom;
import com.valunskii.foxminded.university.repository.exception.DAOException;
import com.valunskii.foxminded.university.repository.executor.Executor;

public class ClassroomDao {
    private static Logger log = Logger.getLogger(ClassroomDao.class);
    private Executor executor = new Executor();

    public List<Classroom> getAll() throws DAOException {
        log.info("Looking for classroom list");
        return executor.execQuery(result -> {
            List<Classroom> list = new ArrayList<>();
            while (result.next()) {
                list.add(new Classroom(result.getString("name")));
            }
            log.info("Return classroom list");
            return list;
        }, "SELECT * FROM classrooms");
    }
    
    public void add(String name) throws DAOException {
        log.info("Add new classroom");
        executor.execUpdate("INSERT INTO classrooms (name) VALUES (?);", name);
        log.info("Classroom added");
    }

    public void delete(int id) throws DAOException {
        log.info("Delete classroom with id = " + id);
        executor.execUpdate("DELETE FROM classrooms WHERE classroom_id = ?", id);
        log.info("Classroom deleted");
    }
    
    public void update(int id, String name) throws DAOException {
        log.info("Update classroom with id = " + id);
        executor.execUpdate("UPDATE classrooms SET name = ? WHERE classroom_id = ?", name, id);
        log.info("Classroom updated");
    }
}

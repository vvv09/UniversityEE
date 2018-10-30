package com.valunskii.foxminded.university.repository.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.valunskii.foxminded.university.repository.entity.Teacher;
import com.valunskii.foxminded.university.repository.exception.DAOException;
import com.valunskii.foxminded.university.repository.executor.Executor;

public class TeacherDao {
    private static Logger log = Logger.getLogger(TeacherDao.class);
    private Executor executor = new Executor();

    public List<Teacher> getAll() throws DAOException {
        log.info("Looking for teacher list");
        return executor.execQuery(result -> {
            List<Teacher> list = new ArrayList<>();
            while (result.next()) {
                list.add(new Teacher(result.getInt("teacher_id"), result.getString("first_name"),
                        result.getString("middle_name"), result.getString("last_name")));
            }
            log.info("Return teacher list");
            return list;
        }, "SELECT * FROM teachers");
    }

    public Teacher get(int id) throws DAOException {
        log.info("Looking for teacher with id = " + id);
        return executor.execQuery(result -> {
            result.next();
            log.info("Return teacher");
            return new Teacher(result.getInt("teacher_id"), result.getString("first_name"),
                    result.getString("middle_name"), result.getString("last_name"));
        }, "SELECT * FROM teachers WHERE teacher_id = ?", id);
    }

    public void add(String firstName, String middleName, String lastName) throws DAOException {
        log.info("Add new teacher");
        executor.execUpdate("INSERT INTO teachers (first_name, middle_name, last_name) VALUES (?, ?, ?);", firstName, middleName, lastName);
        log.info("Teacher added");
    }

    public void delete(int id) throws DAOException {
        log.info("Delete teacher");
        executor.execUpdate("DELETE FROM teachers WHERE teacher_id = ?", id);
        log.info("Teacher deleted");
    }
}

package com.valunskii.foxminded.university.repository.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.valunskii.foxminded.university.repository.entity.Student;
import com.valunskii.foxminded.university.repository.exception.DAOException;
import com.valunskii.foxminded.university.repository.executor.Executor;

public class StudentDao {
    private static Logger log = Logger.getLogger(StudentDao.class);
    private Executor executor = new Executor();

    public List<Student> getAll() throws DAOException {
        log.info("Looking for student list");
        return executor.execQuery(result -> {
            List<Student> list = new ArrayList<>();
            while (result.next()) {
                list.add(new Student(result.getInt("student_id"), result.getString("first_name"),
                        result.getString("middle_name"), result.getString("last_name")));
            }
            log.info("Return student list");
            return list;
        }, "SELECT * FROM students");
    }

    public Student get(int id) throws DAOException {
        log.info("Looking for student with id = " + id);
        return executor.execQuery(result -> {
            result.next();
            log.info("Return student");
            return new Student(result.getInt("student_id"), result.getString("first_name"),
                    result.getString("middle_name"), result.getString("last_name"));
        }, "SELECT * FROM public.students WHERE student_id = ?", id);
    }

    public void add(int id, String firstName, String middleName, String lastName) throws DAOException {
        log.info("Add new student");
        executor.execUpdate("INSERT INTO students VALUES (?, ?, ?, ?);", id, firstName, middleName, lastName);
        log.info("Student added");
    }

    public void delete(int id) throws DAOException {
        log.info("Delete student");
        executor.execUpdate("DELETE FROM students WHERE student_id = ?", id);
        log.info("Student deleted");
    }
}

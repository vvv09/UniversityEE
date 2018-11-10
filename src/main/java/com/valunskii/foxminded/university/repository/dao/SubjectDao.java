package com.valunskii.foxminded.university.repository.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.valunskii.foxminded.university.repository.entity.Subject;
import com.valunskii.foxminded.university.repository.exception.DAOException;
import com.valunskii.foxminded.university.repository.executor.Executor;

public class SubjectDao {
    private static Logger log = Logger.getLogger(SubjectDao.class);
    private Executor executor = new Executor();

    public List<Subject> getAll() throws DAOException {
        log.info("Looking for subject list");
        return executor.execQuery(result -> {
            List<Subject> list = new ArrayList<>();
            while (result.next()) {
                list.add(new Subject(result.getString("name")));
            }
            log.info("return subject list");
            return list;
        }, "SELECT * FROM subjects");
    }
    
    public void add(String name) throws DAOException {
        log.info("Add new subject");
        executor.execUpdate("INSERT INTO subjects (name) VALUES (?);", name);
        log.info("Subject added");
    }

    public void delete(int id) throws DAOException {
        log.info("Delete subject with id = " + id);
        executor.execUpdate("DELETE FROM subjects WHERE subject_id = ?", id);
        log.info("Subject deleted");
    }
    
    public void update(int id, String name) throws DAOException {
        log.info("Update subject with id = " + id);
        executor.execUpdate("UPDATE subjects SET name = ? WHERE subject_id = ?", name, id);
        log.info("Subject updated");
    }
}

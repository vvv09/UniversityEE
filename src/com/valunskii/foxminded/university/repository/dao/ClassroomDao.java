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
        return executor.execQuery("select * from classrooms", result -> {
            List<Classroom> list = new ArrayList<>();
            while (result.next()) {
                list.add(new Classroom(result.getString("name")));
            }
            log.info("Return classroom list");
            return list;
        });
    }
}

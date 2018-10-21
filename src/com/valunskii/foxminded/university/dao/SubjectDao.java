package com.valunskii.foxminded.university.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.valunskii.foxminded.university.dao.executor.Executor;
import com.valunskii.foxminded.university.domain.Subject;

public class SubjectDao {
    private static Logger log = Logger.getLogger(SubjectDao.class);
    private Executor executor = new Executor();

    public List<Subject> getAll() throws SQLException {
        log.info("Looking for subject list");
        return executor.execQuery("select * from subjects", result -> {
            List<Subject> list = new ArrayList<>();
            while (result.next()) {
                list.add(new Subject(result.getString("name")));
            }
            log.info("return subject list");
            return list;
        });
    }
}

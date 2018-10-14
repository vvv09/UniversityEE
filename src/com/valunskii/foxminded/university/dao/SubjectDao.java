package com.valunskii.foxminded.university.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.valunskii.foxminded.university.dao.executor.Executor;
import com.valunskii.foxminded.university.domain.Subject;

public class SubjectDao {
    private Executor executor;

    public SubjectDao(Connection connection) {
        this.executor = new Executor(connection);
    }

    public List<Subject> getAll() throws SQLException {
        return executor.execQuery("select * from subjects", result -> {
            List<Subject> list = new ArrayList<>();
            while (result.next()) {
                list.add(new Subject(result.getString("name")));
            }
            return list;
        });
    }
}

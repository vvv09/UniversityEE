package com.valunskii.foxminded.university.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.valunskii.foxminded.university.dao.executor.Executor;
import com.valunskii.foxminded.university.domain.Classroom;

public class ClassroomDao {
    private Executor executor;

    public ClassroomDao() {
        this.executor = new Executor();
    }

    public List<Classroom> getAll() throws SQLException {
        return executor.execQuery("select * from classrooms", result -> {
            List<Classroom> list = new ArrayList<>();
            while (result.next()) {
                list.add(new Classroom(result.getString("name")));
            }
            return list;
        });
    }
}

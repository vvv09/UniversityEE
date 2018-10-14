package com.valunskii.foxminded.university.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.valunskii.foxminded.university.dao.executor.Executor;
import com.valunskii.foxminded.university.domain.Teacher;

public class TeacherDao {
    private Executor executor;

    public TeacherDao(Connection connection) {
        this.executor = new Executor(connection);
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
}

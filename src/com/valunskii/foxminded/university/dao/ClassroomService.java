package com.valunskii.foxminded.university.dao;

import java.sql.SQLException;
import java.util.List;

import com.valunskii.foxminded.university.domain.Classroom;

public class ClassroomService {
    public static List<Classroom> getAllClassrooms() throws DBException {
        try {
            return (new ClassroomDao().getAll());
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
}

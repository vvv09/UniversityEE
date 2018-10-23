package com.valunskii.foxminded.university.service;

import java.sql.SQLException;
import java.util.List;

import com.valunskii.foxminded.university.repository.dao.ClassroomDao;
import com.valunskii.foxminded.university.repository.entity.Classroom;
import com.valunskii.foxminded.university.repository.exception.DAOException;

public class ClassroomService {
    private static ClassroomDao dao = new ClassroomDao();

    public static List<Classroom> getAllClassrooms() throws DAOException {
        try {
            return (dao.getAll());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}

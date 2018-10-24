package com.valunskii.foxminded.university.service;

import java.util.List;

import com.valunskii.foxminded.university.repository.dao.ClassroomDao;
import com.valunskii.foxminded.university.repository.entity.Classroom;
import com.valunskii.foxminded.university.repository.exception.DAOException;

public class ClassroomService {
    private static ClassroomDao dao = new ClassroomDao();

    public static List<Classroom> getAllClassrooms() throws DAOException {
            return (dao.getAll());
    }
}

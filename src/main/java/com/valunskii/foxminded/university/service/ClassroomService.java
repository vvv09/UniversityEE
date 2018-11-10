package com.valunskii.foxminded.university.service;

import java.util.List;

import com.valunskii.foxminded.university.repository.dao.ClassroomDao;
import com.valunskii.foxminded.university.repository.entity.Classroom;
import com.valunskii.foxminded.university.repository.exception.DAOException;

public class ClassroomService {
    private static ClassroomDao dao = new ClassroomDao();

    public static List<Classroom> getAllClassrooms() throws DAOException {
            return dao.getAll();
    }
    
    public static void addClassroom(String name) throws DAOException {
        dao.add(name);
    }

    public static void deleteClassroom(int id) throws DAOException {
        dao.delete(id);
    }

    public static void updateClassroom(int id, String name) throws DAOException {
        dao.update(id, name);
    }
}

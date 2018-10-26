package com.valunskii.foxminded.university.service;

import java.util.List;

import com.valunskii.foxminded.university.repository.dao.TeacherDao;
import com.valunskii.foxminded.university.repository.entity.Teacher;
import com.valunskii.foxminded.university.repository.exception.DAOException;

public class TeacherService {
    private static TeacherDao dao = new TeacherDao();
    
    public static List<Teacher> getAllTeachers() throws DAOException {
            return dao.getAll();
    }

    public static int addTeacher(String firstName, String middleName, String lastName) throws DAOException {
            List<Teacher> list = dao.getAll();
            dao.add(list.size() + 1, firstName, middleName, lastName);
            return dao.getAll().size();
    }

    public static Teacher getTeacher(int id) throws DAOException {
            return dao.get(id);
    }

    public static int deleteTeacher(int id) throws DAOException {
            dao.delete(id);
            return dao.getAll().size();
    }
}

package com.valunskii.foxminded.university.service;

import java.sql.SQLException;
import java.util.List;

import com.valunskii.foxminded.university.repository.dao.TeacherDao;
import com.valunskii.foxminded.university.repository.entity.Teacher;
import com.valunskii.foxminded.university.repository.exception.DAOException;

public class TeacherService {
    private static TeacherDao dao = new TeacherDao();
    
    public static List<Teacher> getAllTeachers() throws DAOException {
        try {
            return (dao.getAll());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static int addTeacher(String firstName, String middleName, String lastName) throws DAOException {
        try {
            List<Teacher> list = dao.getAll();
            dao.add(list.size() + 1, firstName, middleName, lastName);
            return dao.getAll().size();
        } catch (SQLException e) {
            throw new DAOException(e);
        } 
    }

    public static Teacher getTeacher(int id) throws DAOException {
        try {
            return (dao.get(id));
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static int deleteTeacher(int id) throws DAOException {
        try {
            dao.delete(id);
            return dao.getAll().size();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}

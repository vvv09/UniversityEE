package com.valunskii.foxminded.university.service;

import java.sql.SQLException;
import java.util.List;

import com.valunskii.foxminded.university.repository.dao.StudentDao;
import com.valunskii.foxminded.university.repository.entity.Student;
import com.valunskii.foxminded.university.repository.exception.DAOException;

public class StudentService {
    private static StudentDao dao = new StudentDao();

    public static List<Student> getAllStudents() throws DAOException {
        try {
            return (dao.getAll());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static int addStudent(String firstName, String middleName, String lastName) throws DAOException {
        try {
            List<Student> list = dao.getAll();
            dao.add(list.size() + 1, firstName, middleName, lastName);
            return dao.getAll().size();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static Student getStudent(int id) throws DAOException {
        try {
            return (dao.get(id));
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static int deleteStudent(int id) throws DAOException {
        try {
            dao.delete(id);
            return dao.getAll().size();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}

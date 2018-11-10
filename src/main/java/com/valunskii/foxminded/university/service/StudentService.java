package com.valunskii.foxminded.university.service;

import java.util.List;

import com.valunskii.foxminded.university.repository.dao.StudentDao;
import com.valunskii.foxminded.university.repository.entity.Student;
import com.valunskii.foxminded.university.repository.exception.DAOException;

public class StudentService {
    private static StudentDao dao = new StudentDao();

    public static List<Student> getAllStudents() throws DAOException {
        return dao.getAll();
    }

    public static void addStudent(String firstName, String middleName, String lastName) throws DAOException {
        dao.add(firstName, middleName, lastName);
    }

    public static Student getStudent(int id) throws DAOException {
        return dao.get(id);
    }

    public static void deleteStudent(int id) throws DAOException {
        dao.delete(id);
    }

    public static void updateStudent(int id, String firstName, String middleName, String lastName) throws DAOException {
        dao.update(id, firstName, middleName, lastName);
    }
}

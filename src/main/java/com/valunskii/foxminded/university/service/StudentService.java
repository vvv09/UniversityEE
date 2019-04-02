package com.valunskii.foxminded.university.service;

import java.util.List;

import com.valunskii.foxminded.university.repository.dao.StudentDao;
import com.valunskii.foxminded.university.repository.entity.Student;
import com.valunskii.foxminded.university.repository.exception.DAOException;

public class StudentService {
    private static StudentDao dao = new StudentDao();

    public List<Student> getAllStudents() throws DAOException {
        return dao.getAll();
    }

    public void addStudent(String firstName, String middleName, String lastName, int groupId) throws DAOException {
        dao.add(firstName, middleName, lastName, groupId);
    }

    public Student getStudent(int id) throws DAOException {
        return dao.get(id);
    }

    public void deleteStudent(int id) throws DAOException {
        dao.delete(id);
    }

    public void updateStudent(int id, String firstName, String middleName, String lastName, int groupId) throws DAOException {
        dao.update(id, firstName, middleName, lastName, groupId);
    }
}

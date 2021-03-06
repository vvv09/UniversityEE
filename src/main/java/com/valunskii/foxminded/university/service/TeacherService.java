package com.valunskii.foxminded.university.service;

import java.util.List;

import com.valunskii.foxminded.university.repository.dao.TeacherDao;
import com.valunskii.foxminded.university.repository.entity.Teacher;
import com.valunskii.foxminded.university.repository.exception.DAOException;

public class TeacherService {
    private static TeacherDao dao = new TeacherDao();

    public List<Teacher> getAllTeachers() throws DAOException {
        return dao.getAll();
    }

    public void addTeacher(String firstName, String middleName, String lastName) throws DAOException {
        dao.add(firstName, middleName, lastName);
    }

    public Teacher getTeacher(int id) throws DAOException {
        return dao.get(id);
    }

    public void deleteTeacher(int id) throws DAOException {
        dao.delete(id);
    }

    public void updateTeacher(int id, String firstName, String middleName, String lastName) throws DAOException {
        dao.update(id, firstName, middleName, lastName);
    }
}

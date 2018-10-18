package com.valunskii.foxminded.university.dao;

import java.sql.SQLException;
import java.util.List;

import com.valunskii.foxminded.university.domain.Teacher;

public class TeacherService {
    public static List<Teacher> getAllTeachers() throws DBException {
        try {
            return (new TeacherDao().getAll());
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public static int addTeacher(String firstName, String middleName, String lastName) throws DBException {
        try {
            TeacherDao dao = new TeacherDao();
            List<Teacher> list = dao.getAll();
            dao.add(list.size() + 1, firstName, middleName, lastName);
            return dao.getAll().size();
        } catch (SQLException e) {
            throw new DBException(e);
        } 
    }

    public static Teacher getTeacher(int id) throws DBException {
        try {
            return (new TeacherDao().get(id));
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public static int deleteTeacher(int id) throws DBException {
        try {
            TeacherDao dao = new TeacherDao();
            dao.delete(id);
            return dao.getAll().size();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
}

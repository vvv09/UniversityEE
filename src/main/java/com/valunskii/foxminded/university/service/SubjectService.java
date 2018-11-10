package com.valunskii.foxminded.university.service;

import java.util.List;

import com.valunskii.foxminded.university.repository.dao.SubjectDao;
import com.valunskii.foxminded.university.repository.entity.Subject;
import com.valunskii.foxminded.university.repository.exception.DAOException;

public class SubjectService {
    private static SubjectDao dao = new SubjectDao();
    
    public static List<Subject> getAllSubjects() throws DAOException {
            return dao.getAll();
    }
    
    public static void addSubject(String name) throws DAOException {
        dao.add(name);
    }

    public static void deleteSubject(int id) throws DAOException {
        dao.delete(id);
    }

    public static void updateSubject(int id, String name) throws DAOException {
        dao.update(id, name);
    }
}

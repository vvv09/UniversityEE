package com.valunskii.foxminded.university.service;

import java.util.List;

import com.valunskii.foxminded.university.repository.dao.SubjectDao;
import com.valunskii.foxminded.university.repository.entity.Subject;
import com.valunskii.foxminded.university.repository.exception.DAOException;

public class SubjectService {
    private static SubjectDao dao = new SubjectDao();
    
    public List<Subject> getAllSubjects() throws DAOException {
            return dao.getAll();
    }
    
    public void addSubject(String name) throws DAOException {
        dao.add(name);
    }

    public void deleteSubject(int id) throws DAOException {
        dao.delete(id);
    }
    
    public Subject getSubject(int id) throws DAOException {
        return dao.get(id);
    }

    public void updateSubject(int id, String name) throws DAOException {
        dao.update(id, name);
    }
}

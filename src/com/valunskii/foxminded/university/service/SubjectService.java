package com.valunskii.foxminded.university.service;

import java.util.List;

import com.valunskii.foxminded.university.repository.dao.SubjectDao;
import com.valunskii.foxminded.university.repository.entity.Subject;
import com.valunskii.foxminded.university.repository.exception.DAOException;

public class SubjectService {
    private static SubjectDao dao = new SubjectDao();
    
    public static List<Subject> getAllSubjects() throws DAOException {
            return (dao.getAll());
    }
}

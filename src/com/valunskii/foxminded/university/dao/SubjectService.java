package com.valunskii.foxminded.university.dao;

import java.sql.SQLException;
import java.util.List;

import com.valunskii.foxminded.university.domain.Subject;

public class SubjectService {
    public static List<Subject> getAllSubjects() throws DBException {
        try {
            return (new SubjectDao().getAll());
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
}

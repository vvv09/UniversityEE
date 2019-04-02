package com.valunskii.foxminded.university.service;

import java.util.List;

import com.valunskii.foxminded.university.repository.dao.ClassroomDao;
import com.valunskii.foxminded.university.repository.entity.Classroom;
import com.valunskii.foxminded.university.repository.exception.DAOException;

public class ClassroomService {
    private static ClassroomDao dao = new ClassroomDao();

    public List<Classroom> getAllClassrooms() throws DAOException {
            return dao.getAll();
    }
    
    public void addClassroom(String name) throws DAOException {
        dao.add(name);
    }
    
    public Classroom getClassroom(int id) throws DAOException {
        return dao.get(id);
    }

    public void deleteClassroom(int id) throws DAOException {
        dao.delete(id);
    }

    public void updateClassroom(int id, String name) throws DAOException {
        dao.update(id, name);
    }
}

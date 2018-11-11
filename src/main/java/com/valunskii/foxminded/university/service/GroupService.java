package com.valunskii.foxminded.university.service;

import java.util.List;

import com.valunskii.foxminded.university.repository.dao.GroupsDao;
import com.valunskii.foxminded.university.repository.entity.Classroom;
import com.valunskii.foxminded.university.repository.entity.Group;
import com.valunskii.foxminded.university.repository.entity.Student;
import com.valunskii.foxminded.university.repository.exception.DAOException;

public class GroupService {
    private static GroupsDao dao = new GroupsDao();

    public static List<Group> getAllGroups() throws DAOException {
            return dao.getAll();
    }

    public static void addGroup(String name) throws DAOException {
        dao.add(name);
    }

    public static Group getGroup(int id) throws DAOException {
        return dao.get(id);
    }
    
    public static void deleteGroup(int id) throws DAOException {
        dao.delete(id);
    }

    public static void updateGroup(int id, String name) throws DAOException {
        dao.update(id, name);
    }
}

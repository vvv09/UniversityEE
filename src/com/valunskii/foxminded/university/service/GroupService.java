package com.valunskii.foxminded.university.service;

import java.sql.SQLException;
import java.util.List;

import com.valunskii.foxminded.university.repository.dao.GroupsDao;
import com.valunskii.foxminded.university.repository.entity.Group;
import com.valunskii.foxminded.university.repository.exception.DAOException;

public class GroupService {
    private static GroupsDao dao = new GroupsDao();

    public static List<Group> getAllGroups() throws DAOException {
        try {
            return (dao.getAll());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}

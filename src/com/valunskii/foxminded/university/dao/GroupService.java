package com.valunskii.foxminded.university.dao;

import java.sql.SQLException;
import java.util.List;

import com.valunskii.foxminded.university.domain.Group;

public class GroupService {
    public static List<Group> getAllGroups() throws DAOException {
        try {
            return (new GroupsDao().getAll());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}

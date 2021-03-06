package com.valunskii.foxminded.university.repository.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.valunskii.foxminded.university.repository.entity.Group;
import com.valunskii.foxminded.university.repository.exception.DAOException;
import com.valunskii.foxminded.university.repository.executor.Executor;

public class GroupsDao {
    private static Logger log = Logger.getLogger(GroupsDao.class);
    private Executor executor = new Executor();

    public List<Group> getAll() throws DAOException {
        log.info("Looking for group list");
        return executor.execQuery(result -> {
            List<Group> list = new ArrayList<>();
            while (result.next()) {
                list.add(new Group(result.getInt("group_id"), result.getString("name")));
            }
            log.info("return group list");
            return list;
        }, "SELECT * FROM groups");
    }
    
    public Group get(int id) throws DAOException {
        log.info("Looking for group with id = " + id);
        return executor.execQuery(result -> {
            result.next();
            log.info("Return group");
            return new Group(result.getInt("group_id"), result.getString("name"));
        }, "SELECT * FROM groups WHERE group_id = ?", id);
    }
    
    public void add(String name) throws DAOException {
        log.info("Add new group");
        executor.execUpdate("INSERT INTO groups (name) VALUES (?);", name);
        log.info("Group added");
    }

    public void delete(int id) throws DAOException {
        log.info("Delete group with id = " + id);
        executor.execUpdate("DELETE FROM groups WHERE group_id = ?", id);
        log.info("Group deleted");
    }
    
    public void update(int id, String name) throws DAOException {
        log.info("Update group with id = " + id);
        executor.execUpdate("UPDATE groups SET name = ? WHERE group_id = ?", name, id);
        log.info("Group updated");
    }
}

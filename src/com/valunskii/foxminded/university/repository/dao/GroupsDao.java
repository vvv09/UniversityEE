package com.valunskii.foxminded.university.repository.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.valunskii.foxminded.university.repository.entity.Group;
import com.valunskii.foxminded.university.repository.executor.Executor;

public class GroupsDao {
    private static Logger log = Logger.getLogger(GroupsDao.class);
    private Executor executor = new Executor();

    public List<Group> getAll() throws SQLException {
        log.info("Looking for group list");
        return executor.execQuery("select * from groups", result -> {
            List<Group> list = new ArrayList<>();
            while (result.next()) {
                list.add(new Group(result.getString("name")));
            }
            log.info("return group list");
            return list;
        });
    }

}

package com.valunskii.foxminded.university.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.valunskii.foxminded.university.dao.executor.Executor;
import com.valunskii.foxminded.university.domain.Group;

public class GroupsDao {
    private Executor executor = new Executor();
    
    public List<Group> getAll() throws SQLException{
        return executor.execQuery("select * from groups", result -> {
            List<Group> list = new ArrayList<>(); 
            while(result.next()) {
            list.add(new Group(result.getString("name")));
            }
            return list;
        });
    }

}

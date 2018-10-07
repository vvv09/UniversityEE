package com.valunskii.foxminded.university.dao;

import java.sql.SQLException;
import java.util.List;

import com.valunskii.foxminded.university.domain.Group;

public interface GroupDao {
    
    public Group create();

    public Group read(int id) throws SQLException;

    public void update(Group group);

    public void delete(Group group);
    
    public List<Group> getAll() throws SQLException;
}

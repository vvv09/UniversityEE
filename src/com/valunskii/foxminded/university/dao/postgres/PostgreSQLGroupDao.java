package com.valunskii.foxminded.university.dao.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.valunskii.foxminded.university.dao.GroupDao;
import com.valunskii.foxminded.university.domain.Group;

public class PostgreSQLGroupDao implements GroupDao {
    private final Connection connection;
    
    public PostgreSQLGroupDao(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public Group create() {
        return null;
    }

    @Override
    public Group read(int id) throws SQLException {
        String sql = "SELECT * FROM groups WHERE group_id = ?;";
        PreparedStatement pStatement = connection.prepareStatement(sql);
        pStatement.setInt(1, id);
        ResultSet resultSet = pStatement.executeQuery();
        resultSet.next();
        return new Group(resultSet.getString("name"));      
    }

    @Override
    public void update(Group group) {
        
    }

    @Override
    public void delete(Group group) {
        
    }
    
    @Override
    public List<Group> getAll() throws SQLException{
        String sql = "SELECT * FROM groups;";
        PreparedStatement pStatement = connection.prepareStatement(sql);
        ResultSet resultSet = pStatement.executeQuery();
        
        List<Group> groups = new ArrayList<>();
        while(resultSet.next()) {
            groups.add(new Group(resultSet.getString("name")));
        }
        
        return groups;
    }
}

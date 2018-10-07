package com.valunskii.foxminded.university.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DaoFactory {

    public Connection getConnection() throws SQLException;

    public GroupDao getGroupDao(Connection connection);

    public StudentDao getStudentDao(Connection connection);

}

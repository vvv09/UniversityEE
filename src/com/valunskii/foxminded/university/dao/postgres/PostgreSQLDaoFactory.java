package com.valunskii.foxminded.university.dao.postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.valunskii.foxminded.university.dao.DaoFactory;
import com.valunskii.foxminded.university.dao.GroupDao;
import com.valunskii.foxminded.university.dao.StudentDao;

public class PostgreSQLDaoFactory implements DaoFactory {

    private final String JDBC_DRIVER = "org.postgresql.Driver";
    private final String DB_NAME = "jdbc:postgresql://localhost:5432/foxuniversity";
    private final String USER = "postgres";
    private final String PASS = "1568996";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_NAME, USER, PASS);
    }

    public GroupDao getGroupDao(Connection connection) {
        return new PostgreSQLGroupDao(connection);
    }

    public StudentDao getStudentDao(Connection connection) {
        return null; //new PostgreSQLStudentDao(connection);
    }

    public void registrateDriver() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

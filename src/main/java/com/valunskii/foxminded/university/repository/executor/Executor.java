package com.valunskii.foxminded.university.repository.executor;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.valunskii.foxminded.university.repository.exception.DAOException;

public class Executor {
    private static Logger log = Logger.getLogger(Executor.class);

    public void execUpdate(String query, Object... parameters) throws DAOException {
        log.debug("Open connection to database");
        try (Connection connection = this.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (int i = 0; i < parameters.length; i++) {
                preparedStatement.setObject(i + 1, parameters[i]);
            }
            log.trace("Update data in database");
            preparedStatement.execute();
        } catch (SQLException e) {
            log.warn("Update execution failed", e);
            throw new DAOException("Update execution failed", e);
        }
        log.debug("Close connection to database");
    }

    public <T> T execQuery(ResultHandler<T> handler, String query, Object... parameters) throws DAOException {
        T value = null;
        log.debug("Open connection to database");
        
        try (Connection connection = this.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (int i = 0; i < parameters.length; i++) {
                preparedStatement.setObject(i + 1, parameters[i]);
            }
            log.trace("Get data from database");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                value = handler.handle(resultSet);
            }
        } catch (SQLException e) {
            log.warn("Quary execution failed", e);
            throw new DAOException("Quary execution failed", e);
        }
        log.debug("Open connection to database");
        return value;
    }

    public Connection getConnection() {

        log.trace("Get connection settings from db.properties");
        Properties props = readDbProperties();

        final String DRIVER = props.getProperty("jdbc.driver");
        final String DB_URL = props.getProperty("jdbc.url");
        final String USER = props.getProperty("jdbc.username");
        final String PASS = props.getProperty("jdbc.password");

        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Properties readDbProperties() {
        Properties props = new Properties();
        InputStream in = null;
        try {
            log.trace("Read properties file");
            in = getClass().getClassLoader().getResourceAsStream("db.properties");
            if (in != null) {
                props.load(in);
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Cannot read file");
        } finally {
            if (in != null) {
                try {
                    in.close();
                    log.trace("File closed");
                } catch (IOException ignore) {
                    log.error("Cannot close file");
                }
            }
        }
        return props;
    }
}


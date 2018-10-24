package com.valunskii.foxminded.university.repository.executor;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.valunskii.foxminded.university.repository.exception.DAOException;

public class Executor {
    private static Logger log = Logger.getLogger(Executor.class);

    public void execUpdate(String update) throws DAOException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            log.trace("Open connection");
            connection = this.getConnection();
            try {
                log.trace("Create statement");
                statement = connection.createStatement();
                statement.execute(update);
                try {
                    log.trace("Get result set");
                    resultSet = statement.getResultSet();
                    log.trace("Create object to return");
                } finally {
                    if(resultSet != null) {
                        try {
                            resultSet.close();
                            log.trace("Result set closed");
                        } catch (SQLException e) {
                            log.warn("Cannot close result set", e);
                        }
                    }
                }
            } finally {
                if(statement != null) {
                    try {
                        statement.close();
                        log.trace("Statement closed");
                    } catch (SQLException e) {
                        log.warn("Cannot close statement", e);
                    }
                }
            }
        } catch (SQLException e) {
            log.warn("Update execution failed", e);
            throw new DAOException("Update execution failed", e);
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                    log.trace("Connection closed");
                } catch (SQLException e) {
                    log.warn("Cannot close connection", e);
                }
            }
        }
    }

    public <T> T execQuery(String query, ResultHandler<T> handler) throws DAOException {
        T value = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            log.trace("Open connection");
            connection = this.getConnection();
            try {
                log.trace("Create statement");
                statement = connection.createStatement();
                statement.execute(query);
                try {
                    log.trace("Get result set");
                    resultSet = statement.getResultSet();
                    log.trace("Create object to return");
                    value = handler.handle(resultSet);
                } finally {
                    if(resultSet != null) {
                        try {
                            resultSet.close();
                            log.trace("Result set closed");
                        } catch (SQLException e) {
                            log.warn("Cannot close result set", e);
                        }
                    }
                }
            } finally {
                if(statement != null) {
                    try {
                        statement.close();
                        log.trace("Statement closed");
                    } catch (SQLException e) {
                        log.warn("Cannot close statement", e);
                    }
                }
            }
        } catch (SQLException e) {
            log.warn("Quary execution failed", e);
            throw new DAOException("Quary execution failed", e);
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                    log.trace("Connection closed");
                } catch (SQLException e) {
                    log.warn("Cannot close connection", e);
                }
            }
        }
        return value;
    }

    public Connection getConnection() {

        log.trace("Get connection settings from db.properties");
        Properties props = readDbProperties();

        final String DB_URL = props.getProperty("jdbc.url");
        final String USER = props.getProperty("jdbc.username");
        final String PASS = props.getProperty("jdbc.password");

        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Properties readDbProperties() {
        Properties props = new Properties();
        FileInputStream in = null;
        try {
            log.trace("Read properties file");
            in = new FileInputStream("src\\db.properties");
            props.load(in);
            return props;
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Cannot read file");
        } finally {
            try {
                in.close();
                log.trace("File closed");
            } catch (IOException ignore) {
                log.error("Cannot close file");
            }
        }
        return props;
    }
}
